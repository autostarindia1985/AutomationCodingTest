# AutomationCodingTest
This repository includes the e2e test automation of swiggy application for one order flow. Test scrips are written in Java using selenium java client bindings.
Quick overview of Framework:

Framework is written using Page object model
Test executes in both Chrome and firefox driver. Framework has the capability to execute the same scripts in both the browsers
Test execution is done using TestNG. Reports are available in both HTML and xml format.

## Tools
* Maven
* JUnit
* Selenium Webdriver
* Testng

## Requirements

In order to utilise this project you need to have the following installed locally:

* Maven 3
* Chrome and Chromedriver (UI tests use Chrome by default, can be changed in config)
* Java 1.8
* Eclipse ide

## Execution

Import the project in the local eclipse workspace and build the project to retrieve the related JARS from POM file. Once build is completed scuccessfully right click on testsuite.xml file under pom.naveen and execute as testng.suite.
 Test should automatically launch the firefox and chrome browser and captures the screenshot. Finally the test driver session is closed.
 
 




