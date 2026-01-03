package com.coderay.OrangePIM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailPage extends BasePage{
	public PersonalDetailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h6[normalize-space()='Personal Details']")
	WebElement titlePersonalDetails;

	public WebElement getTitle() {
		return titlePersonalDetails;
	}
}
