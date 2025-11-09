#Author: your.email@your.domain.com
#Keywords Summary :
#Background: List of steps run before each of the scenarios
Feature: TC-Q001 Web login scenarios

  @Positive
  Scenario Outline: TS-01 Login to web-ui and verify the ui
    Given Login with valid <User-ID> and <Password>
    When User logged in with valid credentials
    Then Verify intial screen and all expected elements

    Examples: 
      | User-ID | Password        |
      | admin   | password        |
      | testing | testingPassword |

  @Negitive
  Scenario Outline: TS-02 Login to web-ui and verify the ui
    Given Login with invalid <User-ID> and <Password>
    Then Verify the error popup

    Examples: 
      | User-ID | Password |
      | myname  | password |
