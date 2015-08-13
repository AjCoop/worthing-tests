@TLF3

Feature: Save My Stuff

  As an User
  I will be able to save my stuff in the check my post app


#  Background:
#    Given I am on the Check post page
#    And I click the Save my stuff link


  Scenario: Scenario 1 - Check the mandatory fields for "Save My Stuff-Page One" page
    Given I am on the Save My Stuff page
     When I enter the following data in to the Page one
       | field_id                | value         |
       | page.one.field.one      |               |
       | page.one.field.two      |               |
       | page.one.field.three    |               |
    When I have clicked the "Continue" button on the "Page One" page
    Then I will be informed "This field is mandatory"



 Scenario: Scenario 2 - Continue button passes validation

    Given I am on the Save My Stuff page
     When I enter the following data in to the Page one
       | field_id                | value          |
       | page.one.field.one      | AAAAAA         |
       | page.one.field.two      |                |
       | page.one.field.three    |                |
    When I have clicked the "Continue" button on the "Page One" page
    Then I will progress to the "Page Two" page

 Scenario: Scenario 3 - Continue button passes validation

   Given I am on the Save My Stuff page
   When I enter the following data in to the Page one
     | field_id                | value          |
     | page.one.field.one      | 0!qaz"wsx£     |
     | page.one.field.two      | EDC$RFV5tg     |
     | page.one.field.three    |                |
   When I have clicked the "Continue" button on the "Page One" page
   Then I will progress to the "Page Two" page


 Scenario: Scenario 4 - Continue button passes validation

   Given I am on the Save My Stuff page
   When I enter the following data in to the Page one
      | field_id               | value          |
      | page.one.field.one     | 0!qaz"wsx£     |
      | page.one.field.two     | EDC$RFV5tg     |
      | page.one.field.three   | %tgb^yhn&yh    |
   When I have clicked the "Continue" button on the "Page One" page
   Then I will progress to the "Page Two" page