@manual
Feature: This is a registration page

  Scenario: Test registration page with correct data
    Given I am on home page
    And I go to register page
    When I have entered all mandatory data
    And I click on Sign Up
    Then I should be registered, got a confirmation mail and logged in


  Scenario Outline: Test registration page with incorrect data
    Given I am on home page
    And I go to register page
    When I have entered <firstName>
    And I have entered <lastName>
    And I have entered <mobileNumber>
    And I have entered <email>
    And I have entered <password>
    And I have entered <confirmPassword>
    And I click on Sign Up
    Then I should see <errorMessage>

    Examples:
      | firstName | lastName | mobileNumber | email          | password | confirmPassword | errorMessage                                     |
      |           | Test     | 01234567896  | test@test.com  | 123456   | 123456          | first name is mandatory                          |
      | Test      |          | 01234567896  | test@test.com  | 123456   | 123456          | last name is mandatory                           |
      | Test      | Test     |              | test@test.com  | 123456   | 123456          | mobil number iis mandatory                       |
      | Test      | Test     | 01234567     | test@tetst.com | 123456   | 123456          | please enter a correct mobile number             |
      | Test      | Tst      | 01234567896  |                | 123456   | 123456          | email is mandatory                               |
      | Test      | Test     | 01234567896  | test.com       | 123456   | 123456          | email format is inorrect                         |
      | Test      | Test     | 0123456789   | test@test      | 123456   | 123456          | email format is incorrect                        |
      | Test      | Test     | 0123456789   | test@test.com  |          | 123456          | password is mandatory                            |
      | Test      | Tst      | 0123456789   | test@test.com  | 123456   |                 | confirm password is mandatory                    |
      | Test      | Test     | 01234567896  | test@test.com  | 123456   | 123             | passowrd and confirmation password doesn't match |

