@TLF3

Feature: Save My Stuff

  As an User
  I will be able to save my stuff in the check my post app

  Scenario: Scenario 1 - Mandatory details (One Field on each page) are displayed correctly on the summary page
    Given I am in SMS page
    When I have entered details on Page One
      | required_field         | value          |
      | field one              | field 1        |
    Then I click Continue
    When I have entered details on Page Two
      | required_field         | value          |
      | field one              | field 1        |
    Then I click Submit
    When I am on the SMS Summary Page
    Then I will see the details I have entered

  Scenario: Scenario 2 - Two field details (Two Fields on each page) are displayed correctly on the summary page
    Given I am in SMS page
    When I have entered details on Page One
      | required_field         | value          |
      | field one              | field 1        |
      | field two              | field 2        |
    Then I click Continue
    When I have entered details on Page Two
      | required_field         | value          |
      | field one              | field 1        |
      | field two              | field 2        |
    Then I click Submit
    When I am on the SMS Summary Page
    Then I will see the details I have entered

  Scenario: Scenario 3 - All field details (All Fields on each page) are displayed correctly on the summary page
    Given I am in SMS page
    When I have entered details on Page One
      | required_field         | value          |
      | field one              | field 1        |
      | field two              | field 2        |
      | field three            | field 3        |
    Then I click Continue
    When I have entered details on Page Two
      | required_field         | value          |
      | field one              | field 1        |
      | field two              | field 2        |
      | field three            | field 3        |
    Then I click Submit
   When I am on the SMS Summary Page
    Then I will see the details I have entered