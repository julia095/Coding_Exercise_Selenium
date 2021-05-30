# Coding exercise for Bank Feeds Xero


## Description

The challenge was to automate a story using Selenium Webdriver.
> As a Xero User,
In order to manage my business successfully,
I want to be able to add an “ANZ (NZ)” bank account inside any Xero Organisation.

I created a simple framework using Java, TestNG, Maven and Extent Reports.
Tests will be executed in Chrome. You don't need to add current driver versions as it is being handled by WebDriverManager automatically.

## Challenges and workarounds

I had a challenge with loggin in. Ideally, this step would be better to implement using API endpoints. Bit since there was no such information provided, I had to create a trial, and set security questions and answers to comply with mandatory MFA requirements. I left my trial credentials in the code.

## Prerequisites
- Java jdk-1.8 or higher
- Apache Maven 4 or higher

## How to run tests

At the root of the project there is a **TestNG.xml** file, in which it is necessary to prescribe which classes with tests to be run. At the moment it is set to ANZAccountTest.

**Tests can be run through the IDE or maven goal "test".**

Tests are located in /src/test/java/tests folder.
Page object classes are located in src/test/java/pages

- There are two tests implemented, and 5 more commented in the code. They are not fully finished due to lack of time.

- The test run report is stored in the extent-reports folder - extent-report.html
- Tests retry implemented.  A retrying mechanism will try to run it one more time before set it's status to FAILED.
- log4j configured to capture the test execution logs

## Todo
-  generate bank account numbers
- improve authentication process (possibly API?)
- develop the rest of the test ideas
