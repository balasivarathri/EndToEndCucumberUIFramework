Feature: Validating Login page fileds for Swag Labs

  @Login_Feature
  Scenario Outline: Validating Login fields with valid credentials for Swag Labs site
    Given User can be able to caputre username and passwrod to login to Application UserName<UserName>, Password<Password>
    When User should be login into Swag Labs Home page
    And User can be able to see validate the titile of the page
    Then User should be able to logout from the Swag Labs page

    Examples:
      | UserName      | Password     |
      | standard_user | secret_sauce |