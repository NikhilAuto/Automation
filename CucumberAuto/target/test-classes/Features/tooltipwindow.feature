
#Sample Feature Definition Template

Feature: Validate Tooltip is displayed properly
  
  @tooltip
  Scenario: Validate Tooltip is displayed properly
    Given I am at registration page
    When I click on registration button
    Then I verify the Firstname <FirstName> tooltip
    Then I verify the Lastname <LastName> tooltip

  Examples: 
      | FirstName	| LastName | 
      | Please fill out this field.|Please fill out this field.|
      
      
   @tooltag1
  Scenario: Validate Tooltip is displayed properly second
    Given I am at toolsqa registration page
    Then I verify the Hover to use tooltip