package com.coderay.OrangePIM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	WebElement dashboardText;
	
	@FindBy(xpath="//a[@class='oxd-main-menu-item'][contains(.,'PIM')]")
	WebElement tabPIM;

	public String getDashboardTitle() {
		return dashboardText.getText();
	}

	
	public void clickPimModule() {
		tabPIM.click();
	}
}
