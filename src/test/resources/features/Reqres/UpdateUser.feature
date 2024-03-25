Feature: Reqres Update User

  @Tugas
  #Positive
  Scenario Outline: Update user with valid JSON user id
    Given Update user with valid JSON "<JSON>" and user id <id>
    When Send request update user
    Then Status code should be 200
    And Response body name should be "<name>" and job is "<job>"
    And Validate json schema "UpdateUserJsonSchema.json"
    Examples:
      | id | JSON             | name               | job  |
      | 1  | UpdateUser1.json | Diar Adrinantoko 1 | QA 1 |
      | 2  | UpdateUser2.json | Diar Adrinantoko 2 | QA 2 |
      | 3  | UpdateUser3.json | Diar Adrinantoko 3 | QA 3 |

  @Tugas
  #Negative
  Scenario Outline: Update user with invalid JSON and valid user id
    Given Update user with invalid JSON "<JSON>" and valid user id <id>
    When Send request update user
    Then Status code should be 400

    Examples:
      | id | JSON                    |
      | 1  | UpdateUserInvalid1.json |
      | 2  | UpdateUserInvalid1.json |

  @Tugas
  #Negative
  Scenario Outline: Update user with valid JSON and invalid user id
    Given Update user with valid JSON "<JSON>" and invalid user id <id>
    When Send request update user
    Then Status code should be 404

    Examples:
      | id   | JSON             |
      | 23   | UpdateUser1.json |
      | -1   | UpdateUser2.json |
      | 1000 | UpdateUser3.json |