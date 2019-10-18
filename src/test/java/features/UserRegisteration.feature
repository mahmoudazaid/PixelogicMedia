Feature: User Registration

  I want to check that user can register and login in our website


  Scenario: User Registration
    Given I am on home page
    When I click on Sign Up
    And I have entered user registration data
    Then The user has been logged in successfully
    And I logout

    Scenario: User Can login
      Given I am on home page
      When I click on login
      And I have entered user login data
      Then The user has been logged in successfully
      And I logout

  Scenario: Check registration message delivered
    Given I connect to email "testautomation890@gmail.com" with password "A@123456"
    Then I should receive message with subject "Signed Up successfully"