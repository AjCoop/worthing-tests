@Tests
Feature: Carry out automation of required tests

  Scenario: User must be signed in to see the main page
    Given The user navigates to the main page
    When The user logs in

 Scenario: Create an entry
    Then The user enters in a single row of data

Scenario: Delete entry
     When the user clicks delete


  Scenario: Create multiple entries



