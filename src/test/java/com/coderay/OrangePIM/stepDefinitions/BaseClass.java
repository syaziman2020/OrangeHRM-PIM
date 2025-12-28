package com.coderay.OrangePIM.stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseClass {
	public WebDriver driver;
	public BaseClass(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public static String randomAlpha(int size) {
		return RandomStringUtils.insecure().nextAlphabetic(size);
	}
	
	public static String randomNumeric(int size) {
		return RandomStringUtils.insecure().nextAlphanumeric(size);
	}
	
	public String captureScreen(WebDriver driver, String screenshotName) throws IOException {
		if (driver == null) {
			throw new IOException("WebDriver instance is null. Tidak dapat mengambil screenshot.");
		}
		String dateName = new SimpleDateFormat("yyyy-MM-dd_hh.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/failed-screenshots/" + screenshotName + "_" + dateName
				+ ".png";
		File finalDestination = new File(destination);

		finalDestination.getParentFile().mkdirs();

		FileHandler.copy(source, finalDestination);
		return destination;
	}

}
