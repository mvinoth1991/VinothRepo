Feature: Signing up
  As a user i would be able to sign up


  Scenario Outline: Sign up
    Given I have user details for sign in
    When I click on register new account <emailID>
    Then I should be able to enter details for registration <gender> <fname> <lname> <pwd> <day> <month> <year> <city> <country> <state> account page
    And user should be able to sign up successfully <fname> <lname>
    Examples:Signup
      |gender|fname|lname|pwd|day|month|year|emailID|city|country|state|
      |Mr    |pertest |pertest|Test@123|22|6|1991|digitaltest|Singapore|21|1|

