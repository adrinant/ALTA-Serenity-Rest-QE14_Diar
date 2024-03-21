Feature: Serenity Rest QE 14

  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <pageNumber>
    When Send request get list user
    Then Status code should be 200

    Examples:
      | pageNumber |
      | 1          |
      | 2          |

  @Latihan
  Scenario: Post create user with valid JSON
    Given Create user with valid JSON "CreateUser.json"
    When Send request create new user
    Then Status code should be 201

  @Latihan
  Scenario Outline: Update user with valid JSON user id
    Given Update user with valid JSON <JSON> and user id <id>
    When Send request update user
    Then Status code should be 200
    Examples:
      | id | JSON             |
      | 1  | UpdateUser1.json |
      | 2  | UpdateUser2.json |
      | 3  | UpdateUser3.json |

  @Latihan
  Scenario: Delete user with valid user id
    Given Delete user with valid user id 2
    When Send request delete user
    Then Status code should be 204