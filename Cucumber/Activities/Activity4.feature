@activity4

Feature: Login Test

@LoginWithoutExampleParameter

Scenario: Testing Login without Examples
Given User is on the login page
When User enters "admin" and "password"
Then Read the page title and confirmation message
And Close the Browser