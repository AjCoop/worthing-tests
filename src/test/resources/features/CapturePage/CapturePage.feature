@suite

Feature: Search for something

  Scenario: Error messages for the mandatory fields on the Capture Page
    Given I am on the Search Page
    When I leave all the fields empty
    And I click the submit button
    And  I will get the mandatory error messages displayed on the page

  Scenario: Error messages for the invalid format data entered on the Capture Page
    Given I am on the Search Page
    When I enter invalid UTR and invalid date format
    And I click the submit button
    And  I will get the invalid format error messages displayed on the page

  Scenario: Search using valid UTR,TaxRefType and date entered
    Given I am on the Search Page
    When I enter valid UTR, valid TaxRefType and a valid date format
    And I click the submit button
    Then I will progress to the search Results page