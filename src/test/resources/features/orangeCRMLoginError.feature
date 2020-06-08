Feature: To check the Login Error feature of Orange CRM Application

  Scenario: Login with invalid credentials
    Given user is on the login page2
    When user has invalid credentials
    And user attempts to submit the login form2
    Then user gets the invalid credential alert
