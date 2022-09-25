@smoke @regression
Feature: Search Cities

  @parameterized_scenario_outline_example_google_search @smoke
  Scenario Outline: capitals are on the search page
    When user is on the google page
    And user search for "<world_capitals>"
    Then verify the result has "<world_capitals>"
    Then close the application

    Examples:
      | world_capitals |
      | Denizli        |
      | Trabson        |
      | Berlin         |
      | Toronto        |
