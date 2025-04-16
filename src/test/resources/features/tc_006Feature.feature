Feature: Validate session persistence in the application

  Scenario: Validate user session remains active
    Given the user logs in with valid credentials
    When the user navigates through multiple sections of the application
    Then the session remains active during navigation
    When the user closes and opens the browser without logging out
    Then the session persists and the user is still authenticated