@google_search
Feature: Google Search Functionality

  Scenario: TC01_iPhone search
    Given user is on the google page
    And user search for iPhone
    Then verify the result has iPhone
    Then close the application

@test
  Scenario: TC02_teapot search
    Given user is on the google page
    And user search for teapot
    Then verify the result has teapot
    Then close the application

  @test
  Scenario: TC03_teapot search
    Given user is on the google page
    And user search for tesla
    Then verify the result has tesla
    Then close the application