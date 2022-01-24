@activity2
Feature: Login Test

@loginTest
Scenario: Testing login
Given User is on the login page
When User enters username and password
Then Read the page title and confirmation message
And Close the Browser


