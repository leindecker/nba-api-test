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

  @getUser @getUsers
  Scenario: Get all users
    When I search for all the users
    Then I validate the return of the data according to the contract "usersContract.json"
    And I check the status code 200

  @getUser
  Scenario: Get Specific User
    When I create a new user
    And  I search for the user created
    Then I validate the return of the data according to the contract "responseSpecificUserContract.json"
    And I check the status code 200

  @getUser @getInvalidUser
  Scenario: Get Invalid User
    When I search for invalid user
    Then I validate the message "Resource not found" in "message" field
    And I check the status code 404