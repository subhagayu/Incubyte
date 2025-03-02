@001CreateAccout
Feature: Create an account

Scenario Outline: Create an account to signin
Given User has to launch the browser and click on the create account button "<url>"
Then User has to enter the required fields like "<FirstName>" "<LastName>" "<Email>" "<password>" "<confirmpassword>"


Examples:
|url|FirstName|LastName|Email|password|confirmpassword|
|https://magento.softwaretestingboard.com/|Subhashini|SathyaNarayanan|subhahua@gmail.com|Karthi01*|Karthi01*|

Scenario: User has to SignOut the application
And User has to click on the profile down arrown and click on the SignOut button

Scenario: User has to SignIn with the created account
And User has to click on the signIn button
And User has to enter the "<Email>" "<password>" and user has to click on the SignIn button


