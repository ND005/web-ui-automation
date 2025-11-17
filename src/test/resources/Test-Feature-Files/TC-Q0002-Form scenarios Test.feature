Feature: TC-Q0002 Form page

  @Positive
  Scenario Outline: TS-01 Login to web-ui and verify the ui
    Given Login with valid <User-ID> and <Password>
    When Switch to <Page> screen
    Then Verify all form GUI elements
    Then Fill the form <First-Name> - <Last-Name> details
    And Fill the form with extended data

    Examples: 
      | User-ID | Password        | First-Name | Last-Name | Page |
      | admin   | password        | Dinesh     | Nimmala   | Form |
      | testing | testingPassword | Nimmala    | Dinesh    | Form |
