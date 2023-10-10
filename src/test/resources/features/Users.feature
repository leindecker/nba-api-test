@usersresource
Feature:  Validate users resources
  Background:
    Given  I have logged into the api

  @createUser
  Scenario: Create User
    When I create a new user
    Then I validate the return of the data according to the contract "responseCreateUserContract.json"
    And I check the status code 201