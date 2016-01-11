@TLF1

Feature: Details

  As an User
  I will be able to

# Background:
#   Given I am on the Details page

  Scenario: Scenario 1 - Continue buttons takes to the Personal Details page
    Given I am on the Details Page
    When I click the continue button
    Then I will be directed to the personal details page


  Scenario: Scenario 2 - Error messages will appear when there are fields left empty
    Given I am on the Details Page
    When I click the continue button
    And All of the fields are left blank
    Then Error messages will appear indicating the fields are left blank

  Scenario: Scenario 3 - The information on the details page is correct
    Given I am on the Details Page
    Then The information within the fields should be correct

  Scenario: Scenario 4 - The back button takes you back the start page
    Given I am on the Details Page
    When I click the back button
    Then I will be directed to the start page
