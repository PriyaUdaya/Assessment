@verifyLogo
Feature: Search for a page and verify logo

@searchGivenData
Scenario Outline: Verify the user is able to search a give text
Given user navigate to application
When user enter given <searchText> and click on Search button 
Then click on the link
And verify the logo displayed

Examples:
|searchText|
|J P Morgan|