@usersresource
Feature:  Validate users resources
  Background:
    Given  I have logged into the api

  @createUser
  Scenario: Create User
    When I create a new user
    Then I validate the return of the data according to the contract "responseCreateUserContract.json"
    And I check the status code 201

  @createUser
  Scenario: Create User with email already taken
    When I create a new user with email already taken
    Then I validate the message "[email]" in "field" field
    And I validate the message "[has already been taken]" in "message" field
    And I check the status code 422

  @createInvalidUser
  Scenario: Create User with empty Name
    When I create a new user with empty name
    Then I validate the message "[name]" in "field" field
    And I validate the message "[can't be blank]" in "message" field
    And I check the status code 422

  @createInvalidUser
  Scenario: Create User with empty Email
    When I create a new user with empty email
    Then I validate the message "[email]" in "field" field
    And I validate the message "[can't be blank]" in "message" field
    And I check the status code 422

  @createInvalidUser @gender
  Scenario: Create User with empty Gender
    When I create a new user with empty gender
    Then I validate the message "[gender]" in "field" field
    And I validate the message "[can't be blank, can be male of female]" in "message" field
    And I check the status code 422

  @createInvalidUser
  Scenario: Create User with empty Status
    When I create a new user with empty status
    Then I validate the message "[status]" in "field" field
    And I validate the message "[can't be blank]" in "message" field
    And I check the status code 422