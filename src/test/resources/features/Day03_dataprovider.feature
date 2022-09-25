Feature: validate user can login to their account

  @data_provider_test_address @regression
  Scenario:
    When user visit to application page
    And user clicks on the sign in button
    And user enters login_username and login_password
      | manager1@hic.com | Manager1! |
    And user clicks on my addresses
    And user clicks on add new address
    And enters all required fields
      | FirstName | LastName | Company     | Address  | City    | State  | PostalCode | Country       | HomePhone  | MobilePhone | AddressName |
      | Hamza     | Hatay    | Hooop Dedik | 102012 a | Newyork | Alaska | 12121      | United States | 5879856420 | 6597845898  | random      |
    Then click on Save Button
    Then Take screenshoot
    Then user close the test page
