Feature: Reqres Register User
  As a user i want to register user to reqres API

  @Tugas
  #Positive
  Scenario Outline: Register user with valid JSON
    Given Register user with valid JSON "<JSON>"
    When Send request register user
    Then Status code should be 200
    And Response body id should be id <id>
    And Validate json schema "RegisterSuccessfulJsonSchema.json"

    Examples:
      | id | JSON               |
      | 4  | RegisterUser1.json |
      | 8  | RegisterUser2.json |

  @Tugas
  Scenario Outline: Outline: Register user with invalid JSON
    Given Register user with invalid JSON "<JSON>"
    When Send request register user
    Then Status code should be 400
    And Response body should "<error>"

    Examples:
      |  | JSON                      | error                     |
      |  | RegisterUserInvalid1.json | Missing email or username |
      |  | RegisterUserInvalid2.json | Missing password          |
      |  | RegisterUserInvalid3.json | Missing email or username |

