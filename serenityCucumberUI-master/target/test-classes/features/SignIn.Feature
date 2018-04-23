Feature: Singup in to imdb account
  In order to encourage buyers to make a purchase
  As a seller
  I want buyers to be able to see details about a product

  Scenario Outline:: Register for new account
    Given I have user details for sign in
    When I click on login <ID> <Password>
    Then I should be able to see my <ID> account page
  Examples:
      | ID             | Password |
      | digitaltest1   | Password1 |
