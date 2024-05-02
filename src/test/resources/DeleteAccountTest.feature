Feature: Check and research the functionalities ot the web page
  As an admin user,
  I want to check and research the functionalities ot the web page.


  Scenario: Add new comment to order
    Given The user is on the web page
    When He enters the credentials
    And He adds new comment
    Then He checks the result with assert