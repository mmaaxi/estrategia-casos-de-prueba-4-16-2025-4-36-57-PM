Feature: Password Recovery

  Scenario: Validate Password Recovery
    Given the user is on the login page
    When the user clicks on "Forgot password" link
    Then the user is redirected to the password recovery page
    When the user enters a valid email
    Then the system accepts the email format
    When the user clicks on the "Send" button
    Then a confirmation message is displayed and a recovery email is sent