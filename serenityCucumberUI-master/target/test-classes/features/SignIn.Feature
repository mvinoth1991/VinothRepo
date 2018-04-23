Feature: Signing to Straits times
  As a user i would be able to sign in

  Scenario Outline: Signing to Straits times
    Given I have user details for sign in
    When I click on login <ID> <Password>
    Then I should be able to see my <ID> account page
  Examples:
      | ID             | Password |
      | digitaltest1   | Password1 |