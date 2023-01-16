Feature: Basic login to verify the user credentials who have a registered account

  Scenario: : Login with correct user information
    Given The user has to be an account
    When The user provide the username and password
    Then The response status code is OK