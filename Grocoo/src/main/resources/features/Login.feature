Feature: Login

  Background:

  Scenario: Enter user name and password
    Given Enter the user name <username>
    Then enter the password <password>
    And click on submit
    Then verify user is logged in

    Examples:
    |username|password|
    |abcd|1234|