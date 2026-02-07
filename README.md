# OrangeHRM Test Automation Framework

## Project Overview
This project contains automated test cases for the OrangeHRM demo application using Selenium WebDriver and TestNG. The framework follows the Page Object Model (POM) design pattern.

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- IntelliJ IDEA

## Framework Design
- Page Object Model (POM)
- Data-driven testing using TestNG DataProviders
- Explicit waits using WebDriverWait

## Test Coverage
- Login functionality (valid, invalid, empty fields)
- Logout Functionality
- Password reset functionality

## How to Run
1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run test classes or execute `mvn test`

## Notes
Some tests may occasionally fail due to dynamic content loading on demo applications. Explicit waits are used to minimize flakiness.

## Author
Dilushika Sewwandi
