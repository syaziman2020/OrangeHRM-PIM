package com.coderay.OrangePIM.hooks;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.coderay.OrangePIM.stepDefinitions.BaseClass;
import com.coderay.OrangePIM.utilities.ScenarioContext;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Hooks {
	public WebDriver driver;
	public static Properties property;

	@Before
	public void setup() throws IOException {

		FileReader file = new FileReader("./src//test//resources//config.properties");
		property = new Properties();
		property.load(file);

		String browserName = property.getProperty("browser");

		switch (browserName.toLowerCase()) {
		case "chrome":
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--guest");
			driver = new ChromeDriver(options);
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return;
		}

		ScenarioContext.setContext("driver", driver);

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
	}

	@After
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				BaseClass base = new BaseClass(driver);

				String path = base.captureScreen(driver, scenario.getName());
				System.out.println("Screenshot disimpan di: " + path);

				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				Allure.addAttachment("Failed Scenario Screenshot", new ByteArrayInputStream(screenshot));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (driver != null) {
			driver.quit();
		}
		ScenarioContext.clear();
	}

}
