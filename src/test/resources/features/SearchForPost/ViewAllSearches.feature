@TLF1
Feature: View all Searches Page

  Scenario: View all Searches Page is correctly displayed
    Given  I am on the Search Page
    And   I have selected UTR
    When I enter the following data
      | field_id                | value         |
      | page.search.id          | 1234          |
      | page.search.day         | 01            |
      | page.search.month       | 01            |
      | page.search.year        | 2015          |
    And I click the find post button
    Then The Not Found status is displayed
    Then I click the view all searches link
    Then I should see a page displayed with the results of the all the searches the user has made.
    Then I click back button to go back to the Search Page.