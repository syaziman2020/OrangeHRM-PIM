package com.coderay.OrangePIM.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.coderay.OrangePIM.pageObjects.AddEmployeePage;
import com.coderay.OrangePIM.pageObjects.DashboardPage;
import com.coderay.OrangePIM.pageObjects.PersonalDetailPage;
import com.coderay.OrangePIM.pageObjects.PimPage;
import com.coderay.OrangePIM.utilities.ScenarioContext;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps {

	WebDriver driver;
	PimPage pimPage;
	AddEmployeePage addEmpPage;
	DashboardPage dashPage;
	PersonalDetailPage personalPage;
	
	String firstEmployeeId;
	public AddEmployeeSteps() {
		this.driver = (WebDriver) ScenarioContext.getContext("driver");
		this.dashPage = new DashboardPage(driver);
		this.pimPage = new PimPage(driver);
		this.addEmpPage = new AddEmployeePage(driver);
		this.personalPage = new PersonalDetailPage(driver);
	}

	@When("User clicks the PIM module")
	public void user_clicks_the_PIM_module() {
		dashPage.clickPimModule();
	}

	@Then("User sees the title text {string}")
	public void user_sees_the_title_text(String title) {
		String result = pimPage.getPimTitle();
		assertEquals(title, result);
	}

	@When("User clicks the add button")
	public void user_clicks_the_add_button() {
		firstEmployeeId = pimPage.getFirstId();
		pimPage.clickAddEmployee();
	}

	@And("User enter the random first name and lastname")
	public void user_enter_the_random_first_name_and_lastname() {
		String firstName = "Cofirst-" + BaseClass.randomNumeric(3);
		String lastName = "Colast-" + BaseClass.randomNumeric(3);
		addEmpPage.setFirstName(firstName);
		addEmpPage.setLastName(lastName);
	}
	
	@And("User enter the random lastname")
	public void user_enter_the_random_lastname() {
		String lastName = "Colast-" + BaseClass.randomNumeric(3);
		addEmpPage.setLastName(lastName);
	}

	@And("User delete the default employee id")
	public void user_delete_the_default_employee_id() {
		int length = addEmpPage.getEmpIdField().getDomProperty("value").length();
		System.out.println(length);
		addEmpPage.clearUsingKeyboard(addEmpPage.getEmpIdField(), length);
	}
	
	@And("User enter the random employee id")
	public void user_enter_the_random_employee_id() {
		String employeId = "EMP-"+BaseClass.randomNumeric(4);
		addEmpPage.setEmployeeId(employeId);
	}

	@And("User clicks the save button")
	public void user_clicks_the_save_button() {
		addEmpPage.clickSave();
	}

	@Then("User sees the success dialog")
	public void user_sees_the_success_dialog() {
		assertTrue(addEmpPage.getToastSuccess().isDisplayed());
	}
	
	@Then("User sees the validation first name required")
	public void user_sees_the_validation_first_name_required() {
		assertTrue(addEmpPage.getValidateFirstName().isDisplayed());
	}

	@And("User go to personal details page")
	public void user_go_to_personal_details_page() {
		assertTrue(personalPage.getTitle().isDisplayed());
	}
	
	@And("User enter the existing employee id")
	public void user_enter_the_existing_employee_id() {
		System.out.println(firstEmployeeId);
		addEmpPage.setEmployeeId(firstEmployeeId);
	}
	
	@Then("User sees the validation employee id required")
	public void user_sees_the_validation_employee_id_required() {
		assertTrue(addEmpPage.getValidateEmployeeId().isDisplayed());
	}
	
	@And("User switch enabled login details")
	public void user_switch_enabled_login_details() {
		addEmpPage.clickSwitchLogin();
	}
	
	@And("User enter the username")
	public void user_enter_the_username() {
		String username = "user-"+firstEmployeeId;
		addEmpPage.setUserName(username);
	}
	
	@And("User enter the password {string}")
	public void user_enter_the_password(String password) {
		addEmpPage.setPassword(password);
	}
	
	@And("User enter the confirm password {string}")
	public void user_enter_the_confirm_password(String confirmPass) {
		addEmpPage.setConfirmPass(confirmPass);
	}
	
	@And("User enter the username with existing data {string}")
	public void user_enter_the_username_with_existing_data(String username) {
		addEmpPage.setUserName(username);
	}
	
	@Then("User sees the error validate")
	public void user_sees_the_error_validatet() {
		assertTrue(addEmpPage.getFormValidate().isDisplayed());
	}

}
