#Author: your.email@your.domain.com
#Keywords Summary :
Feature: Login page scenario list.

	@SmokeTest
  Scenario Outline: Verify user is able to login using valid credentials.
    Given user is on login page
    When user enters "<username>" and "<password>"
    And user clicks on login button
    Then user is navigated to home page

    Examples: 
      | username                 | password  |
      | nikhilatdalmia@gmail.com | Nikhil@99 |
