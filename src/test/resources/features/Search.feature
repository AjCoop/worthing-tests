@suite

  Feature: Search for something

    Scenario: Search using UTR
      Given I am on the Search Page
      When I search using my UTR
      Then I can capture all my details correctly

    Scenario: Search using Tax Ref
      Given I am on the Search Page
      When I search using my Tax Ref
      Then I can capture all my details correctly