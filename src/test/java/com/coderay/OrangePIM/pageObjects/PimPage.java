package com.coderay.OrangePIM.pageObjects;

import java.util.List;

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
	
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
	WebElement employeNameField;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//span[contains(normalize-space(.), 'Record')]")
	WebElement txtTotalRecords;
	
	@FindBy(xpath ="//div[@role='row']/div[@role='cell'][3]")
	List<WebElement> dataEmployeeNames;
	
	@FindBy(xpath = "//div[@role='listbox']//div")
	List<WebElement> listSelectedDropdown;
	
	@FindBy(xpath = "(//div[contains(@class, 'oxd-select-text--after')])[2]")
	WebElement dropdownInclude;
	
	@FindBy(xpath = "//div[@role='table']")
	WebElement tableEmployee;
	
	public WebElement getTableEmployee() {
		return tableEmployee;
	}
	
	public void clickDropdownInclude() {
		dropdownInclude.click();
	}
	
	public void selectedDropdown(int index) {
		listSelectedDropdown.get(index).click();
	}
	
	public List<WebElement> getDataEmployeeNames() {
		return dataEmployeeNames;
	}
	
	public void clickSearch() {
		btnSearch.click();
	}
	
	public void setEmployeeName(String name) {
		employeNameField.sendKeys(name);
	}
	
	public int getTotalRecords() {
		String value = txtTotalRecords.getText();
		int total = 0;
		
		if(value.equals("No Records Found")) {
			return total;
		}else {
			total = Integer.parseInt(value.substring(1,value.indexOf(") Record")));
			return total;
		}
	}
	
	public String getFirstId() {
		return firstEmployeId.getText();
	}
	
	public WebElement getFirstEmployeId() {
		return firstEmployeId;
	}
	
	public void clickAddEmployee() {
		btnAdd.click();
	}
	
	public String getPimTitle() {
		return pimTitleText.getText();
	}

}
