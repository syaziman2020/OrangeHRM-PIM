package com.coderay.OrangePIM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PimPage extends BasePage{
	public PimPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement btnAdd;
	
	@FindBy(xpath = "//h6[normalize-space()='PIM']")
	WebElement pimTitleText;
	
	@FindBy(xpath = "(//div[@role='cell'])[2]/div")
	WebElement firstEmployeId;
	
	public String getFirstId() {
		return firstEmployeId.getText();
	}
	
	public void clickAddEmployee() {
		btnAdd.click();
	}
	
	public String getPimTitle() {
		return pimTitleText.getText();
	}

}
