Feature: To check the login feature of Orange CRM Application

  Scenario: Login with Valid Credentials
    Given user is on the Login page
    When user has valid credentials
    And user attempts to submit the login form
    Then user landed on the user dashboard page
