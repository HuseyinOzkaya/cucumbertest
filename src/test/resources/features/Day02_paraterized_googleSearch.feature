@parameterized_google_search @regression
Feature: Google Search Functionality

  Scenario: TC01_iPhone search
    Given user is on the google page
    And user search for "Denizli"
    Then verify the result has "Denizli"
    Then close the application


  @parameterized_scenario_outline_example_google_search
  Scenario Outline:
    Given user is on the google page
    And user search for "<toSearch>"
    Then verify the result has "<toSearch>"
    Then close the application

    Examples:
      | toSearch |
      | iPhone   |
      | flower   |
      | teapot   |
      | tesla    |


  @parameterized_scenario_outline_example_google_search @failed_test
  Scenario Outline:
    Given user is on the google page
    And user search for "<toSearch>"
    Then verify the result has "<toLook>"
    Then close the application

    Examples:
      | toSearch | toLook |
      | iPhone   | iPhone |
      | flower   | flower |
      | teapot   | teapot  |
      | tesla    | tesla  |