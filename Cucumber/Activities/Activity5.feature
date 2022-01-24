@activity5

Feature: Login Test

@LoginWithExampleParameter
Scenario Outline: Testing Login with Example
Given User is on the login page
When User enters "<username>" and "<password>"
Then Read the page title and confirmation message
And Close the Browser

Examples:
|username|password|
|admin|password|
|user|password|
