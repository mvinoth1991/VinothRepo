Feature: Sign in
  As a user i would be able to sign up

//
Scenario Outline: Sign in
Given I have user details for sign in
When I enter username and password <paswd> <emailID>
Then verify user is logged in successfully <fname><lname>

Examples: SignIn
  |paswd|emailID|fname|lname|
|Test@123|testingautomation1234@gmail.com|Test|Automation|
  |Test@123|teautomation1234@gmail.com|Test|Automation|
  |Test@123|teautomation1234|Test|Automation|