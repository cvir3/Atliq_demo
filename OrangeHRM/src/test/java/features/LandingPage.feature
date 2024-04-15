Feature: OrangeHRM

  Scenario Outline: Login OrangeHRM Page
    @Login
    Given launch chrome browser "https://opensource-demo.orangehrmlive.com/"
    When user login into webapp with "<Username>" and password "<Password>"
    Then user navigate to dashboard
    Examples:
      | Username | Password |
      | Admin    | admin123 |

  Scenario: Admin add user from the user management
  @AddUser
    Given admin add the user
    When click on the add button
    Then close browser