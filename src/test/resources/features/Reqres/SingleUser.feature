Feature: Reqres Single User

  @Tugas
  #Positive-TC
  Scenario Outline: Get single user with valid user id
    Given Get single user with valid user id <id>
    When Send request get single user
    Then Status code should be 200
    And Response body data id should be <id>
    And Validate json schema "GetSingleUserJsonSchema.json"

    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas
  #Negative-TC
  Scenario Outline: Get single user with invalid user id
    Given Get single user with invalid user id <id>
    When Send request get single user
    Then Status code should be 404

    Examples:
      | id |
      | 13 |
      | 14 |
      | 15 |