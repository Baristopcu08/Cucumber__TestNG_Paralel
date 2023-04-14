Feature: Login Func

  Scenario:
Given User on homepage
When user login with data
|username |standard_user|
|password |secret_sauce |
Then login should be successfull