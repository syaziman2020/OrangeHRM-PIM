Feature: Check List Employe on PIM Module

  Background:
    Given User opens the browser and navigates to the login page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters username "Admin" and password "admin123"
    And User clicks the login button
    Then User sees the title text "Dashboard" in the header
    When User clicks the PIM module
    Then User sees the title text "PIM"

  @SmokeTest
  Scenario: find employee with partial name
  	When User enter the employee name for search
  	And User click the search button
  	Then Total record is not zero
  	And Data Record is not empty
  	
 @SmokeTest
 Scenario: find employee with current and include past employee
 	When User set include current and past employees
 	And User click the search button
	Then Total record is not zero
  	And Data Record is not empty
  	
 @SmokeTest
 Scenario: Check total data with default pagination
 	Then User sees the default is maximum 50
 	
@SmokeTest
@Negatif
Scenario: Search employee name without record data
	When User enter the employee name not exist
	And User click the search button
  	Then Total record is zero
  	And Data Record is empty