Feature: Serenity Rest QE 14

  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <pageNumber>
    When Send request get list user
    Then Status code should be 200
    And Response body page should be <pageNumber>
    And Validate json schema "ListUsersJsonSchema.json"

    Examples:
      | pageNumber |
      | 1          |
      | 2          |

  @Latihan
  Scenario: Post create user with valid JSON
    Given Create user with valid JSON "CreateUser.json"
    When Send request create new user
    Then Status code should be 201
    And Response body name should be "Diar Adrinantoko" and job is "QA Engineer"
    And Validate json schema "CreateUserJsonSchema.json"

  @Latihan
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

  @Latihan
  Scenario: Delete user with valid user id
    Given Delete user with valid user id 2
    When Send request delete user
    Then Status code should be 204