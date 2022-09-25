
Feature: user shoud login using manager credentials

  @manager_login
  Scenario Outline:
    When user is on the application page
    And user clicks on the login button
    And user enters manager credentials "<email>" and "<password>"
    Then verify <"username"> is displayed
    Then close the test page


    Examples:
      | email            | password  | username        |
      | manager1@hic.com | Manager1! | Manager Denizli |
      | manager2@hic.com | Manager2! | Manager Trabzon |


