package com.coderay.OrangePIM.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.coderay.OrangePIM.pageObjects.AddEmployeePage;
import com.coderay.OrangePIM.pageObjects.DashboardPage;
import com.coderay.OrangePIM.pageObjects.PimPage;
import com.coderay.OrangePIM.utilities.ScenarioContext;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ListEmployeeSteps {
	
	WebDriver driver;
	PimPage pimPage;
	AddEmployeePage addEmpPage;
	DashboardPage dashPage;
	
	
	String firstEmployeeId;
	public ListEmployeeSteps() {
		this.driver = (WebDriver) ScenarioContext.getContext("driver");
		this.dashPage = new DashboardPage(driver);
		this.pimPage = new PimPage(driver);
	}
	
	@When("User enter the employee name for search")
	public void user_enter_the_employee_name_for_search() {
		String firstName = pimPage.getDataEmployeeNames().getFirst().getText();
		pimPage.setEmployeeName(firstName);
	}
	
	@And("User click the search button")
	public void user_click_the_search_button() throws InterruptedException {
		pimPage.clickSearch();
		Thread.sleep(Duration.ofSeconds(2));
	}
	
	@Then("Total record is not zero")
	public void total_record_is_not_zero() {
		assertTrue(pimPage.getTotalRecords() > 0);
	}
	@Then("Total record is zero")
	public void total_record_is_zero() {
		assertTrue(pimPage.getTotalRecords() == 0);
	}
	
	@And("Data Record is not empty")
	public void data_record_is_not_empty() {
		pimPage.scrollToElement(pimPage.getTableEmployee());
		assertTrue(pimPage.getDataEmployeeNames().size() > 0);
	}
	@And("Data Record is empty")
	public void data_record_is_empty() {
		pimPage.scrollToElement(pimPage.getTableEmployee());
		assertFalse(pimPage.getDataEmployeeNames().size() > 0);
	}
	
	@When("User set include current and past employees")
	public void user_set_include_current_and_past_employees() {
		pimPage.clickDropdownInclude();
		pimPage.selectedDropdown(1);
	}

	@Then("User sees the default is maximum {int}")
	public void user_sees_the_default_is_maximum_data(int total) {
		int result = pimPage.getTotalRecords();
		if(result <= total) {
			assertTrue(result == pimPage.getDataEmployeeNames().size());
		}else {
			assertTrue(pimPage.getDataEmployeeNames().size() == total);
		}
	}
	
	@When("User enter the employee name not exist")
	public void user_enter_the_employee_name_not_exist() {
		String name = BaseClass.randomAlpha(8);
		pimPage.setEmployeeName(name);
	}
}
