@TLF1
Feature: Start button

  Scenario: Start button correctly takes me to the disclosure reference number page
    Given I am on the start page
    When I click the start button
    Then I should be taken to the disclosure reference number page


  Scenario: The first drop button opens a block of text
    Given I am on the start page
    When I click on the first drop text
    Then I should be able to see the hidden text


  Scenario: The second drop button opens a block of text
    Given I am on the start page
    When I click on the second drop text
    Then I should be able to see the hidden text