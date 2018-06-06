Feature: Signing up
  As a user i would be able to sign up

  Scenario Outline: Sign up
    Given I have user details for sign in
    When I click on register new account <emailID>

    Examples:
      | emailID       |
      | digitaltest   |

    Then I should be able to enter details for registration <gender> <fname><lname><pwd><day><month><year> account page
    And user should be able to sign up successfully
    Examples:
      |gender|fname|lname|pwd|day|month|year|
    |Mr    |test |ltest|Test@123|22|June|1991|