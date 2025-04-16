Feature: Validation of error messages and visual feedback on login

  Scenario: Validate error messages and visual feedback during login
    Given the user is on the login page
    When the user enters incorrect information into both fields
    Then the system shows error messages for both fields
    When the user corrects the information and clicks 'Log In'
    Then the error messages disappear and the authentication proceeds