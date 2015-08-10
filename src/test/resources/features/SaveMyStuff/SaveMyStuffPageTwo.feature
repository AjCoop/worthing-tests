@TLF1

Feature: Save My Stuff

  As an User
  I will be able to save my stuff in the check my post app


#  Background:
#    Given I am on the Check post page
#    And I click the Save my stuff link


  Scenario: Scenario 1 - Check the mandatory fields for "Save My Stuff-Page Two" page
    Given I am on the SMS Page 1
    When I enter the following data in to the Page 1
      | required_field         | value          |
      | field one              | 0!qaz"wsx£     |
      | field two              | EDC$RFV5tg     |
      | field three            | %tgb^yhn&yh    |
    Then I have clicked the "Continue" button on the "Page 1" page
    Then I am on the SMS Page Two
    When I enter the following data in to the Page Two
      | required_field          | value         |
      | field one               |               |
      | field two               |               |
      | field three             |               |
    When I have clicked the "Continue" button on the "Page Two" page
    Then I will be informed that "This field is mandatory"

  Scenario: Scenario 2 - Continue button passes validation

    Given I am on the SMS Page 1
    When I enter the following data in to the Page 1
      | required_field         | value          |
      | field one              | 0!qaz"wsx£     |
      | field two              | EDC$RFV5tg     |
      | field three            | %tgb^yhn&yh    |
    Then I have clicked the "Continue" button on the "Page 1" page
    Then I am on the SMS Page Two
    When I enter the following data in to the Page Two
      | required_field          | value          |
      | field one               | AAAAAA         |
      | field two               |                |
      | field three             |                |
    When I have clicked the "Continue" button on the "Page Two" page
    Then I will progress to the "summary" page


  Scenario: Scenario 3 - Continue button passes validation

    Given I am on the SMS Page 1
    When I enter the following data in to the Page 1
      | required_field         | value          |
      | field one              | 0!qaz"wsx£     |
      | field two              | EDC$RFV5tg     |
      | field three            | %tgb^yhn&yh    |
    Then I have clicked the "Continue" button on the "Page 1" page
    Then I am on the SMS Page Two
    When I enter the following data in to the Page Two
      | required_field          | value          |
      | field one               | 0!qaz"wsx£     |
      | field two               | EDC$RFV5tg     |
      | field three             |                |
    When I have clicked the "Continue" button on the "Page Two" page
    Then I will progress to the "summary" page



  Scenario: Scenario 4 - Continue button passes validation
    Given I am on the SMS Page 1
    When I enter the following data in to the Page 1
      | required_field         | value          |
      | field one              | 0!qaz"wsx£     |
      | field two              | EDC$RFV5tg     |
      | field three            | %tgb^yhn&yh    |
    Then I have clicked the "Continue" button on the "Page 1" page
    Then I am on the SMS Page Two
    When I enter the following data in to the Page Two
      | required_field         | value          |
      | field one              | 0!qaz"wsx£     |
      | field two              | EDC$RFV5tg     |
      | field three            | %tgb^yhn&yh    |
    When I have clicked the "Continue" button on the "Page Two" page
    Then I will progress to the "summary" page
