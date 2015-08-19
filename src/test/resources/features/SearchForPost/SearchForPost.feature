@TLF1

Feature: Search for Post

  Scenario: Error messages for the mandatory fields on the Capture Page
    Given I am on the Search Page
    When I enter the following data
      | field_id                | value         |
      | page.search.id          |               |
      | page.search.day         |               |
      | page.search.month       |               |
      | page.search.year        |               |
    And I click the find post button
    Then  I will get the mandatory error messages displayed on the page


  Scenario: Error messages for the invalid date format data entered on the Capture Page
    Given  I am on the Search Page
    When I enter the following type
      | type        |
      | utr         |
    When I enter the following data
      | field_id                | value         |
      | page.search.id          | 1234          |
      | page.search.day         | 32            |
      | page.search.month       | 13            |
      | page.search.year        | 0007          |
    And I click the find post button
    Then I will get the invalid date format error messages displayed on the page

  Scenario: Error messages for the invalid UTR format data entered on the Capture Page
    Given  I am on the Search Page
    When I enter the following type
      | type        |
      | utr         |
    When I enter the following data
      | field_id                | value         |
      | page.search.id          | !"£$%^        |
      | page.search.day         | 10            |
      | page.search.month       | 12            |
      | page.search.year        | 2014          |
    And I click the find post button
    Then I will get the invalid UTR format error messages displayed on the page

  Scenario: Search using valid UTR,TaxRefType and date entered where the Status is Not Found
    Given I am on the Search Page
    When I enter the following type
      | type        |
      | utr         |
    When I enter the following data
      | field_id                | value         |
      | page.search.id          | AB56789       |
      | page.search.day         | 28            |
      | page.search.month       | 09            |
      | page.search.year        | 2015          |
    And I click the find post button
    Then I will progress to the search Results page
    Then The Not Found status is displayed


  Scenario: Search using valid VRN,TaxRefType and date entered where the Status is Not Found
    Given I am on the Search Page
    When I enter the following type
      | type        |
      | vrn         |
    When I enter the following data
      | field_id                | value         |
      | page.search.id          | 0A12340       |
      | page.search.day         | 28            |
      | page.search.month       | 01            |
      | page.search.year        | 2015          |
    And I click the find post button
    Then I will progress to the search Results page
    Then The Not Found status is displayed

  Scenario: Search using valid UTR,TaxRefType and date entered where the Status is Received
    Given I am on the Search Page
    When I enter the following type
      | type        |
      | utr         |
    When I enter the following data
      | field_id                | value         |
      | page.search.id          | 1234          |
      | page.search.day         | 01            |
      | page.search.month       | 07            |
      | page.search.year        | 2015          |
    And I click the find post button
    Then I will progress to the search Results page
    Then The Received status is displayed
    Then I click the back button to go back to the search page

  Scenario: Search using valid UTR,TaxRefType and date entered where the Status is In Progress
    Given I am on the Search Page
    When I enter the following type
      | type        |
      | utr         |
    When I enter the following data
      | field_id                | value         |
      | page.search.id          | AB56789       |
      | page.search.day         | 28            |
      | page.search.month       | 05            |
      | page.search.year        | 2015          |
    And I click the find post button
    Then I will progress to the search Results page
    Then The In Progress status is displayed
    Then I click the back button to go back to the search page