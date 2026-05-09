# Selenium Automation Framework – MakeMyTripp

## Project Overview

This document describes a **professional Selenium WebDriver automation framework** developed using **Java, TestNG, and Maven**. The framework follows **industry best practices** to ensure scalability, maintainability, and stability in real-world automation projects.

The framework automates critical user workflows such as:

* Login validation
* Product listing and product details verification
* Cart validation
* Checkout and account-related flows

This project is suitable for **enterprise automation teams, interview demonstrations, and CI/CD-ready test automation setups**.

---

## Technology Stack

* **Programming Language:** Java 17
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **IDE:** Eclipse
* **Reporting:** Extent Reports
* **Data-Driven Testing:** Excel and JSON
* **Version Control:** Git and GitHub

---

## Framework Design Principles

* Page Object Model (POM)
* Single Responsibility Principle
* Reusable utility-driven architecture
* Explicit waits instead of hard-coded delays
* Clean separation between test logic and page logic

---

## Project Structure

```
MakeMyTripp
│
├── pom.xml
├── README.md
├── .gitignore
│
├── src/main/java
│   ├── pages
│   │   ├── LoginPage.java
│   │   ├── ProductDetails.java
│   │   ├── ProductCart.java
│   │   ├── ContactPage.java
│   │   └── OpenAccountPage.java
│   │
│   └── utils
│       ├── DriverFactory.java
│       ├── ElementUtils.java
│       ├── ConfigReader.java
│       ├── ScreenshotUtil.java
│       ├── ExcelUtil.java
│       └── JsonUtil.java
│
├── src/main/resources
│   └── config.properties
│
├── src/test/java
│   ├── tests
│   │   ├── BaseTest.java
│   │   ├── LoginTest.java
│   │   ├── ProductDetailTest.java
│   │   ├── VerifyCartTest.java
│   │   └── OpenAccountTest.java
│   │
│   ├── dataproviders
│   │   ├── ExcelDataProviders.java
│   │   └── JsonDataProvider.java
│   │
│   └── listeners
│       └── TestListener.java
│
└── src/test/resources
    ├── loginData.json
    └── testng.xml
```

---

## Key Framework Components

### DriverFactory

* Centralized WebDriver initialization
* Browser selection controlled via configuration
* Designed for parallel execution using `ThreadLocal`

### ElementUtils

* Wrapper over Selenium interactions
* Handles explicit waits for visibility and clickability
* JavaScript fallback for blocked or intercepted elements
* Improves overall test stability

### BaseTest

* Handles browser setup and teardown
* Provides reusable flows such as login
* Contains no test assertions

### Page Classes

* One page = one class
* Contains locators and page-level actions only
* No test logic or assertions

### Data Providers

* JSON-based login and runtime test data
* Excel-based test scenario support
* Integrated using TestNG `@DataProvider`

### Test Listener

* Tracks test execution lifecycle
* Captures screenshots on failure
* Integrates reporting automatically

---

## Configuration Management

All environment-level values are maintained in:

```
src/main/resources/config.properties
```

Example configuration:

```
browser=chrome
baseUrl=https://automationexercise.com
```

---

## Test Execution

### Run Using Maven

```
mvn clean test
```

### Run Using TestNG

* Right-click `testng.xml`
* Select **Run As → TestNG Suite**

---

## Reporting and Screenshots

* Extent Reports generated after test execution
* Screenshots captured automatically on test failure
* Build artifacts and reports excluded from Git

---

## Best Practices Followed

* No hard-coded waits in test logic
* Clean Git history using `.gitignore`
* Modular and scalable framework design
* Enterprise-ready coding standards

---

## Future Enhancements

* Parallel test execution
* Jenkins CI/CD integration
* Cross-browser testing
* Cloud execution support

---

## Author

**Prabhat Bhardwaj**

Senior QA / Automation Engineer

GitHub: [https://github.com/Prabhat-bhardwaj](https://github.com/Prabhat-bhardwaj)

LinkedIn: [https://www.linkedin.com/in/qa-prabhat-bhardwaj](https://www.linkedin.com/in/qa-prabhat-bhardwaj)
