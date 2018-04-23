Feature: Search Most watched TV Shows
  In order to encourage buyers to make a purchase
  As a seller
  I want buyers to be able to see details about a product

  Scenario: Register for new account
    Given Tv shows name to look into most watched list is "Walking Dead"
    When I search in the most watched list
    Then I should be able to find and see details of the series