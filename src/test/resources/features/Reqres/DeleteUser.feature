Feature: Reqres Delete User

  @Tugas
  #Positive
  Scenario Outline: Delete single user with valid user id
    Given Delete single user with valid user id <id>
    When Send request delete single user
    Then Status code should be 204

    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas
    #Negative
  Scenario Outline: Delete single user with invalid user id
    Given Delete single user with invalid user id <id>
    When Send request delete single user
    Then Status code should be 404

    Examples:
      | id   |
      | -1   |
      | 1000 |
      | 23   |