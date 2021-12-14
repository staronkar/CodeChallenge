@CountDown
Feature: CountDown

  Background:
    Given the user is on eggtimer website

  Scenario: Verification of CountDown Functionality
    And the user waits for page to load
    When the user enters 25 seconds as the timer
    And the user clicks on Go Button
    Then the counter starts
    And countdown happens every second
    And verify that remaining time decreases every second.


