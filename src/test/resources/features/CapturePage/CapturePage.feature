@TLF1

Feature:  forSearch Post

  Scenario: Error messages for the mandatory fields on the Capture Page
    Given I am on the Search Page
    When I leave all the fields empty
    And I click the submit button
    Then  I will get the mandatory error messages displayed on the page

  Scenario: Error messages for the invalid format data entered on the Capture Page
    Given I am on the Search Page,I enter invalid UTR and invalid date format and I click the submit button
    Then  I will get the invalid format error messages displayed on the page

  Scenario: Search using valid UTR,TaxRefType and date entered
    Given I am on the Search Page,I enter valid UTR, valid TaxRefType and a valid date and click the submit button
    Then I will progress to the search Results page

  Scenario: Search using valid UTR,TaxRefType and date entered where the Status is Received
    Given I am on the Search Page,I enter valid UTR, valid TaxRefType and a valid date and click the submit button where the status is Received
    Then I will progress to the search Results page and the Received status is displayed
    Then I click the back button to go back to the search page
