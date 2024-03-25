Feature: Reqres Register & Login User

  @Tugas
  Scenario Outline: User login with valid body email and password
    Given User login with valid JSON "<JSON>"
    When Send request post login user
    Then Status code should be 200
    And Validate json schema "LoginUserValidJsonSchema.json"

    Examples:
      | JSON                 |
      | UserLoginValid1.json |
      | UserLoginValid2.json |

  @Tugas
  Scenario Outline: User login with invalid body email and password
    Given User login with invalid JSON "<JSON>"
    When Send request post login user
    Then Status code should be 400

    Examples:
      | JSON                   |
      | UserLoginInvalid1.json |
      | UserLoginInvalid2.json |
      | UserLoginInvalid3.json |