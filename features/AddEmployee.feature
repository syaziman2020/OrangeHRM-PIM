Feature: Add Employe on PIM Module

  Background:
    Given User opens the browser and navigates to the login page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  @SmokeTest
  Scenario: Add employee minimal valid fields
    When User enters username "Admin" and password "admin123"
    And User clicks the login button
    Then User sees the title text "Dashboard" in the header
    When User clicks the PIM module
    Then User sees the title text "PIM"
    # add employee data
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User clicks the save button
    
    #verify the employee data
    Then User sees the success dialog
    And User go to personal details page
  
  @SmokeTest
  Scenario: Manual Employee ID unik
  	When User enters username "Admin" and password "admin123"
    And User clicks the login button
    Then User sees the title text "Dashboard" in the header
    When User clicks the PIM module
    Then User sees the title text "PIM"
    # add employee data
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the random employee id
    And User clicks the save button
    #verify the employee data
    Then User sees the success dialog
    And User go to personal details page
    
 @SmokeTest
 @Negatif
  Scenario: Validasi mandatory First Name kosong
    When User enters username "Admin" and password "admin123"
    And User clicks the login button
    Then User sees the title text "Dashboard" in the header
    When User clicks the PIM module
    Then User sees the title text "PIM"
    # add employee data
    When User clicks the add button
    And User enter the random lastname
    And User delete the default employee id
    And User clicks the save button
    
    #verify the employee data
    Then User sees the validation first name required
    
    
 @SmokeTest
 @Negatif
  Scenario: Validasi duplikat Employee ID
    When User enters username "Admin" and password "admin123"
    And User clicks the login button
    Then User sees the title text "Dashboard" in the header
    When User clicks the PIM module
    Then User sees the title text "PIM"
    # add employee data
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the existing employee id
    And User clicks the save button
    
    #verify the employee data
    Then User sees the validation employee id required
    
@SmokeTest
  Scenario: Create Login Details - sukses (Enabled)
  	When User enters username "Admin" and password "admin123"
    And User clicks the login button
    Then User sees the title text "Dashboard" in the header
    When User clicks the PIM module
    Then User sees the title text "PIM"
    # add employee data
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the random employee id
    And User switch enabled login details
    And User enter the username
    And User enter the password "Rahasia@123"
    And User enter the confirm password "Rahasia@123"
    And User clicks the save button
    #verify the employee data
    Then User sees the success dialog
    And User go to personal details page
    
 @SmokeTest
 @Negatif
  Scenario: Create Login Details - sukses (Enabled)
  	When User enters username "Admin" and password "admin123"
    And User clicks the login button
    Then User sees the title text "Dashboard" in the header
    When User clicks the PIM module
    Then User sees the title text "PIM"
    # add employee data
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the random employee id
    And User switch enabled login details
    And User enter the username with existing data "Admin"
    And User enter the password "Rahasia@123"
    And User enter the confirm password "Rahasia@123"
    And User clicks the save button
    #verify the employee data
    Then User sees the error validate
    
 @SmokeTest
 @Negatif
  Scenario: Create Login Details - password mismatch
  	When User enters username "Admin" and password "admin123"
    And User clicks the login button
    Then User sees the title text "Dashboard" in the header
    When User clicks the PIM module
    Then User sees the title text "PIM"
    # add employee data
    When User clicks the add button
    And User enter the random first name and lastname
    And User delete the default employee id
    And User enter the random employee id
    And User switch enabled login details
    And User enter the username
    And User enter the password "Rahasia@123"
    And User enter the confirm password "Rahasia@1234"
    And User clicks the save button
    #verify the employee data
    Then User sees the error validate
    
    
    
   
