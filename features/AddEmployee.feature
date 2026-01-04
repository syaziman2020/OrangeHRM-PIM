Feature: Add Employe on PIM Module

  Background:
    Given User opens the browser and navigates to the login page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters username "Admin" and password "admin123"
    And User clicks the login button
    Then User sees the title text "Dashboard" in the header
    When User clicks the PIM module
    Then User sees the title text "PIM"

  @SmokeTest
  Scenario: Add a new employee using only mandatory fields
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User clicks the save button
    # verify the employee data
    Then User sees the success dialog
    And User go to personal details page

  @SmokeTest
  Scenario: Add a new employee with minimum required fields and a unique manual ID
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the random employee id
    And User clicks the save button
    # verify the employee data
    Then User sees the success dialog
    And User go to personal details page

  @SmokeTest @Negatif
  Scenario: Validate error when First Name is empty
    When User clicks the add button
    And User enter the random lastname
    And User delete the default employee id
    And User clicks the save button
    # verify the employee data
    Then User sees the error validate

  @SmokeTest @Negatif
  Scenario: Validate error for duplicate Employee ID
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the existing employee id
    And User clicks the save button
    # verify the employee data
    Then User sees the error validate

  @SmokeTest
  Scenario: Successfully create login details with enabled status
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the random employee id
    And User switch enabled login details
    And User enter the username
    And User enter the password "Rahasia@123"
    And User enter the confirm password "Rahasia@123"
    And User clicks the save button
    # verify the employee data
    Then User sees the success dialog
    And User go to personal details page

  @SmokeTest @Negatif
  Scenario: Successfully create login details with enabled status
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the random employee id
    And User switch enabled login details
    And User enter the username with existing data "Admin"
    And User enter the password "Rahasia@123"
    And User enter the confirm password "Rahasia@123"
    And User clicks the save button
    # verify the employee data
    Then User sees the error validate

  @SmokeTest @Negatif
  Scenario: Validate error when passwords do not match
    When User enters username "Admin" and password "admin123"
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the random employee id
    And User switch enabled login details
    And User enter the username
    And User enter the password "Rahasia@123"
    And User enter the confirm password "Rahasia@1234"
    And User clicks the save button
    # verify the employee data
    Then User sees the error validate

  @SmokeTest @Negatif
  Scenario: Validate error when photo file size exceeds the limit
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User upload photo profile
    And User clicks the save button
    # verify the employee data
    Then User sees the error validate

  @SmokeTest
  Scenario: Successfully create login details with disabled status
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the random employee id
    And User switch enabled login details
    And User enter the username
    And User set disabled status radio
    And User enter the password "Rahasia@123"
    And User enter the confirm password "Rahasia@123"
    And User clicks the save button
    # verify the employee data
    Then User sees the success dialog
    And User go to personal details page
