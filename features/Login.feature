Feature: Login to OrangeHRM Dashboard

  As a user of the OrangeHRM system
  I want to log into the application using my credentials
  So that I can access the HR management features

  Background:
    Given User opens the browser and navigates to the login page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  @SmokeTest
  Scenario: Successful login with valid credentials
    When User enters username "Admin" and password "admin123"
    And User clicks the login button
    Then User sees the title text "Dashboard" in the header
    
  @Negatif
  Scenario: Login failed with invalid credential
  	When User enters username "<username>" and password "<password>"
  	And User clicks the login button
    Then User sees the alert invalid credential
	
	Examples:
		| username | password |
		| John	   | Rahasia123|
		| Doe	   | AdminKeren |
		| Uray 	   | Uhuyyy		|