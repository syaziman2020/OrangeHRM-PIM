package com.coderay.OrangePIM.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*; 

import org.openqa.selenium.WebDriver;

import com.coderay.OrangePIM.pageObjects.DashboardPage;
import com.coderay.OrangePIM.pageObjects.LoginPage;
import com.coderay.OrangePIM.utilities.ScenarioContext;

public class LoginSteps {
    
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashPage;
    
    public LoginSteps() {
    	this.driver  = (WebDriver) ScenarioContext.getContext("driver");
    	this.loginPage = new LoginPage(driver);
    	this.dashPage = new DashboardPage(driver);
    }
    

    @Given("User opens the browser and navigates to the login page {string}")
    public void user_opens_the_browser_and_navigates_to_the_login_page(String url) {
        assertNotNull(driver, "Driver instance is null!");
        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @And("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLogin();
    }


    @Then("User sees the title text {string} in the header")
    public void user_sees_the_title_text_in_the_header(String expectedTitle) {
        String actualTitle = dashPage.getDashboardTitle();
        assertEquals(expectedTitle, actualTitle, "Header title mismatch!");
    }
    
    @Then("User sees the alert invalid credential")
    public void user_sees_the_alert_invalid_credential() {
    	assertTrue(loginPage.getAlertInvalid().isDisplayed());
    }
}