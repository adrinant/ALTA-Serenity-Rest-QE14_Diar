Feature: Serenity Rest QE 14
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <pageNumber>
    When Send request get list user
    Then Status code should be 200

    Examples:
      | pageNumber |
      | 1          |
      | 2          |

    Scenario: Post create user with valid JSON
      Given Create user with valid JSON "CreateUser.json"
      When Send request create new user
      Then Status code should be 201