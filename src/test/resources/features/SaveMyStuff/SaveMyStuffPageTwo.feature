@TLF3

Feature: Save My Stuff

  As an User
  I will be able to save my stuff in the check my post app


#  Background:
#    Given I am on the Check post page
#    And I click the Save my stuff link


  Scenario: Scenario 1 - Check the mandatory fields for "Save My Stuff-Page Two" page
    Given I am on the SMS Page 1
    When I enter the following data in to the Page 1
      | field_id               | value          |
      | page.one.field.one     | 0!qaz"wsx£     |
      | page.one.field.two     | EDC$RFV5tg     |
      | page.one.field.three   | %tgb^yhn&yh    |
    Then I have clicked the "Continue" button on the "Page 1" page
    Then I am on the SMS Page Two
    When I enter the following data in to the Page Two
      | field_id                | value         |
      | page.two.field.one      |               |
      | page.two.field.two      |               |
      | page.two.field.three    |               |
    When I have clicked the "Continue" button on the "Page Two" page
    Then I will be informed that "This field is mandatory"

  Scenario: Scenario 2 - Continue button passes validation

    Given I am on the SMS Page 1
    When I enter the following data in to the Page 1
      | field_id               | value          |
      | page.one.field.one     | 0!qaz"wsx£     |
      | page.one.field.two     | EDC$RFV5tg     |
      | page.one.field.three   | %tgb^yhn&yh    |
    Then I have clicked the "Continue" button on the "Page 1" page
    Then I am on the SMS Page Two
    When I enter the following data in to the Page Two
      | field_id                | value          |
      | page.two.field.one      | AAAAAA         |
      | page.two.field.two      |                |
      | page.two.field.three    |                |
    When I have clicked the "Continue" button on the "Page Two" page
    Then I will progress to the "summary" page


  Scenario: Scenario 3 - Continue button passes validation

    Given I am on the SMS Page 1
    When I enter the following data in to the Page 1
      | field_id               | value          |
      | page.one.field.one     | 0!qaz"wsx£     |
      | page.one.field.two     | EDC$RFV5tg     |
      | page.one.field.three   | %tgb^yhn&yh    |
    Then I have clicked the "Continue" button on the "Page 1" page
    Then I am on the SMS Page Two
    When I enter the following data in to the Page Two
      | field_id                | value          |
      | page.two.field.one      | 0!qaz"wsx£     |
      | page.two.field.two      | EDC$RFV5tg     |
      | page.two.field.three    |                |
    When I have clicked the "Continue" button on the "Page Two" page
    Then I will progress to the "summary" page



  Scenario: Scenario 4 - Continue button passes validation
    Given I am on the SMS Page 1
    When I enter the following data in to the Page 1
      | field_id               | value          |
      | page.one.field.one     | 0!qaz"wsx£     |
      | page.one.field.two     | EDC$RFV5tg     |
      | page.one.field.three   | %tgb^yhn&yh    |
    Then I have clicked the "Continue" button on the "Page 1" page
    Then I am on the SMS Page Two
    When I enter the following data in to the Page Two
      | field_id               | value          |
      | page.two.field.one     | 0!qaz"wsx£     |
      | page.two.field.two     | EDC$RFV5tg     |
      | page.two.field.three   | %tgb^yhn&yh    |
    When I have clicked the "Continue" button on the "Page Two" page
    Then I will progress to the "summary" page
