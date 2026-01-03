package com.coderay.OrangePIM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends BasePage{
	public AddEmployeePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNameField;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastNameField;
	
	
	@FindBy(xpath = "//p[contains(@class, 'oxd-text--toast-title') and text()='Success']")
	WebElement toastSuccess;
	
	@FindBy(xpath = "(//input[contains(@class,'oxd-input')])[5]")
	WebElement employeeIdField;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;
	
	@FindBy(xpath = "//div[@class='oxd-input-group']//div[1]//span[1]")
	WebElement validateFirstName;
	
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	WebElement validateEmployeId;
	
	@FindBy(xpath = "//span[contains(@class,'oxd-switch-input')]")
	WebElement switchLogin;
	
	@FindBy(xpath = "(//input[@autocomplete='off'])[1]")
	WebElement usernameField;
	
	@FindBy(xpath = "(//input[@autocomplete='off'])[2]")
	WebElement passwordField;
	
	@FindBy(xpath = "(//input[@autocomplete='off'])[3]")
	WebElement confirmPassField;
	
	@FindBy(xpath = "//span[contains(@class,'oxd-input-field-error-message')]")
	WebElement formValidate;
	
	public WebElement getFormValidate() {
		return formValidate;
	}
	
	public void setUserName(String username) {
		usernameField.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void setConfirmPass(String confirmPass) {
		confirmPassField.sendKeys(confirmPass);
	}
	
	public void setFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public WebElement getValidateFirstName() {
		return validateFirstName;
	}
	
	
	public void setLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void clearEmployeeId() {
		employeeIdField.clear();
	}
	
	public WebElement getEmpIdField() {
		return employeeIdField;
	}
	
	public void setEmployeeId(String id) {
		employeeIdField.sendKeys(id);
	}
	
	public void clickSave() {
		btnSave.click();
	}
	public WebElement getToastSuccess() {
		return toastSuccess;
	}
	
	public WebElement getValidateEmployeeId() {
		return validateEmployeId;
	}
	
	public void clickSwitchLogin() {
		switchLogin.click();
	}

}
