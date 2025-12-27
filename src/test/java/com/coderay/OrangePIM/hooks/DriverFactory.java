//package com.coderay.OrangePIM.hooks;
//
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class DriverFactory {
//	public WebDriver driver;
//	
//
//	public static void initializeDriver(String browser, Properties property) {
//
//		switch (browser) {
//		case "chrome":
//			Map<String, Object> prefs = new HashMap<String, Object>();
//			prefs.put("credentials_enable_service", false);
//			prefs.put("profile.password_manager_enabled", false);
//			prefs.put("profile.password_manager_leak_detection_enabled", false);
//			ChromeOptions options = new ChromeOptions();
//			options.setExperimentalOption("prefs", prefs);
//			options.addArguments("--disable-notifications");
//			options.addArguments("--disable-popup-blocking");
//			options.addArguments("--guest");
//			driver = new ChromeDriver(options);
//			break;
//		case "edge":
//			driver = new EdgeDriver();
//			break;
//		case "firefox":
//			driver = new FirefoxDriver();
//			break;
//		default:
//			System.out.println("Invalid browser");
//			return;
//		}
//		
//		driver.manage().deleteAllCookies();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		driver.get(property.getProperty("appURL"));
//
//		driver.manage().window().maximize();
//
//	}
//}
