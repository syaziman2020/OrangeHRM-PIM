# OrangeHRM Test Automation - PIM Module

This repository contains an automated testing framework for the **PIM (Personnel Information Management)** module of the OrangeHRM Open Source application. It is built using **Java**, **Selenium WebDriver**, and **Cucumber** following the **Page Object Model (POM)** design pattern.

## 🚀 Features Implemented

* **PIM Module - Add Employee:**
* Add employee with minimal valid fields.
* Manual Unique Employee ID entry.
* Mandatory field validation (First Name).
* Duplicate Employee ID validation.
* Create Login Details (Enabled/Disabled status).
* Password mismatch validation.
* Profile picture file size limit validation.



## 🛠️ Tech Stack

* **Language:** Java 21
* **Testing Framework:** JUnit 5
* **BDD Framework:** Cucumber
* **Browser Automation:** Selenium WebDriver
* **Reporting:** * Allure Report
* Cucumber HTML & JSON Reports


* **Build Tool:** Maven

## 📂 Project Structure

Based on the current implementation:

```text
src/test/java
├── com.coderay.OrangePIM.hooks           # Setup & Teardown (Screenshots on failure)
├── com.coderay.OrangePIM.pageObjects     # Element repositories (POM)
├── com.coderay.OrangePIM.runners         # Test Execution Entry Point (JUnit 5)
├── com.coderay.OrangePIM.stepDefinitions # Gherkin step implementations
└── com.coderay.OrangePIM.utilities       # Helpers (DriverFactory, ConfigReader)
src/test/resources
└── features                              # BDD Feature files (Gherkin)
datatest                                  # Test assets (e.g., sample_profile.jpg)

```

## ⚙️ Prerequisites

Ensure you have the following installed:

* **JDK 21**
* **Maven**
* **Google Chrome** (or preferred browser)
* **Allure Commandline** (to view interactive reports)

## 🏃 Running the Tests

### Execute all tests via Maven:

```bash
mvn clean test

```

### Execute by Tag:

To run specific tests (e.g., Smoke Tests):

```bash
mvn test -Dcucumber.filter.tags="@SmokeTest"

```

## 📊 Reporting

### 1. Cucumber Reports

Standard reports are generated automatically after execution in:
`target/cucumber-reports/`

### 2. Allure Report

This project uses Allure for advanced visualization:

1. Run the tests to generate `allure-results`.
2. Generate and open the report using:

```bash
allure serve allure-results

```

## 📝 Key Highlights

* **Dynamic Data:** Uses randomized strings for First Name, Last Name, and IDs to ensure test independence.
* **Failure Capture:** Automated screenshots are attached to the report upon any step failure (configured in `Hooks.java`).
* **Clean Code:** Separation of concerns between Page Objects and Step Definitions for high maintainability.

---