package com.coderay.OrangePIM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	@CacheLookup
	WebElement usernameField;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	@CacheLookup
	WebElement passwordField;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
	WebElement alertInvalidCredential;
	
	
	public void setUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public WebElement getAlertInvalid() {
		return alertInvalidCredential;
	}

}
