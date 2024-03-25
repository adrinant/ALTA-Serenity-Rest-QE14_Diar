Feature: Reqres Delayed Response
  As a user i want to get delayed response

  @Tugas
  #Positive-TC
  Scenario: Get delayed response with valid delay parameter
    Given Get delayed response with valid delay parameter 2
    When Send request get delayed response
    Then Status code should be 200
    And Response body page should be 1 and data id 1 with email "george.bluth@reqres.in"
    And Validate json schema "DelayedResponseJsonSchema.json"

  #Negative-TC
  Scenario: Get delayed response with invalid delay parameter
    Given Get delayed response with invalid delay parameter "##"
    When Send request get delayed response
    Then Status code should be 404