@sms
Feature: Save My Stuff


  Scenario: Scenario 1 - Check the headings and fields for SMS page two
    Given I am on the SMS page two
    And The tile will be Page two
    And I will be asked for Field One
    And I will be asked for Field Two
    And I will be asked for Field Three

  Scenario: Scenario 2 - As a user I want to navigate to SMS page two and ensure data can be entered
    Given I am on the SMS page two
    When I enter just mandatory data
      | required_field          | value          |
      | field one               | Test Text      |
    And I click the "submit" button
   #Then  I will be taken to "SMS Page Summary"

  Scenario: Scenario 3 - As a user I want to navigate to SMS page two and ensure data can be entered
    Given I am on the SMS page two
    When I enter data in all fields
      | required_field          | value                  |
      | field one               | Text and Num 123One    |
      | field two               | Text and Num 123Two    |
      | field three             | Text and Num 123Three  |
    And I click the "submit" button
    #Then  I will be taken to "SMS Page Summary"


  Scenario: Scenario 4 - As a user I want to navigate to SMS page two and ensure data can be entered
    Given I am on the SMS page two
    When I do not enter mandatory data
      | required_field          | value          |
      | field one               |                |
      | field two               | Text           |
      | field three             | Text           |
    And I click the "submit" button
   Then  I will be displayed the correct error message



  Scenario: Scenario 5 - As a user I want to navigate to SMS page two and ensure data can be entered
    Given I am on the SMS page two
    When I enter no data in all fields
      | required_field          | value                  |
      | field one               |                        |
      | field two               |                        |
      | field three             |                        |
    And I click the "submit" button
    #Then  I will be taken to "SMS Page Summary"