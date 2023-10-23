@gorest
@postResource
Feature:  Validate posts resources
  Background:
    Given  I have logged into the api
    When I create a new user

  @createPost
  Scenario: Create Post
    When I create a new post
    Then I validate the return of the data according to the contract "/posts/responseCreatePostContract.json"
    And I check the status code 201

  @createPost
  Scenario: Get Posts by User
    When I create a new post
    Then I search all posts by user
    Then I validate the return of the data according to the contract "/posts/responseGetPostsContract.json"
    And I check the status code 200

  @createPost
  Scenario: Delete Post
    When I create a new post
    Then I delete the post
    And I check the status code 204
