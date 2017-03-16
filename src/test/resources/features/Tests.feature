@Tests
Feature: Carry out automation of required tests

  Scenario: User must be signed in to see the main page
    Given The user navigates to the main page
    When The user logs in

 Scenario: Create an entry
    Then The user enters holiday inn, tree road, Adam Cooper, 4534534534 and adam@adam.COM as their data


Scenario: Delete entry
     When the user clicks delete
     Then the row is deleted


  Scenario Outline: Create multiple entries
    When The user enters <hotel>, <address>, <owner>, <phone> and <email> as their data

    Examples:
    | hotel | address | owner | phone | email |
    | asd   | sadadss | sdfdsf| 12324223| sdf@sd|
    | agh   | wddef | sdfwddwsf| 12434323| sdf@sd|
    | akj   | wdws | wddwsf| 1234333| sdf@sd|



