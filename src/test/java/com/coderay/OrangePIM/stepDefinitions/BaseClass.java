package com.coderay.OrangePIM.stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	public WebDriver driver;
	//---page object----
	
	public String randomAlpha(int size) {
		return RandomStringUtils.insecure().nextAlphabetic(size);
	}
	
	public String randomNumeric(int size) {
		return RandomStringUtils.insecure().nextAlphanumeric(size);
	}

}
