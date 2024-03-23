Feature: Reqres Register User

  @Tugas
  #Positive
  Scenario Outline: Register user with valid JSON
    Given Register user with valid JSON "<JSON>"
    When Send request register user
    Then Status code should be 200
    And Response body id should be id <id>
    #Kurang JSONSchema

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
      |                            | JSON                      | error                     |
      | Empty Email                | RegisterUserInvalid1.json | Missing email or username |
      | Empty Password             | RegisterUserInvalid2.json | Missing password          |
      | Empty Email Empty Password | RegisterUserInvalid3.json | Missing email or username |

