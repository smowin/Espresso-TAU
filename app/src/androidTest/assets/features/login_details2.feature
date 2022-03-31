Feature: Enter login details

  @e2e
  @smoke
  Scenario Outline: Successful Login
    Given I start the application
    When I enter valid email <email>
    And I enter valid password <password>
    And I close the keyboard
    Then I click sign in button
    Then I expect to see successful login message

    Examples:
    | email | password |
    | test23@gmail.com | 12345678 |
    | test27@gmail.com | 91921qqq1 |