@TLF1
Feature: Declaration navigation links

  Scenario: Continue button takes the user to the summary page
    Given That I am on the declaration page
    When I click the continue button
    Then I will be taken to the summary page

  Scenario: Back button takes the user to the personal-details page
    Given: That I am on the declaration page
    When I click on the back button
    Then I will be taken to the personal-details page