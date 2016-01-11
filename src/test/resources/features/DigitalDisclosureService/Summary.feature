@TLF1
Feature: Summary page

  Scenario: Back button correctly takes the user back to the declaration page
    Given I am on the summary page
    When I click the back button on the summary page
    Then I will be taken back to the summary page

  Scenario: Submit button currently reloads the page
    Given I am on the summary page
    When I click on the submit button
    Then Currently I will remain on the summary page