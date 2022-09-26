Feature: Testing admin can login

  @excel @smoke
  Scenario: admin_login_page
    When user is on the application page
    And user clicks on the login button
    And user enters manager credentials from excel
    Then verify <"username"> is displayed
    Then close the test page

    @unexpected_fail
  Scenario: admin_login_page
    And user enters manager credentials from excel 2
    Then verify <"username"> is displayed