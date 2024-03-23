Feature: Reqres List Resources

  @Tugas
    #Positive
  Scenario: Get all list resources with valid parameter
    Given Get all list resources with valid parameter
    When Send request get all list resources
    Then Status code should be 200
    And Response body page should be 1
    And Validate json schema "ListResourcesJsonSchema.json"

  @Tugas
    #Positive
  Scenario Outline: Get single resources with valid data id
    Given Get single resources with valid data id <id>
    When Send request get single list resources
    Then Status code should be 200
    And Response body data id should be id <id>
    And Validate json schema "GetSingleListResourcesJsonSchema.json"

    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas
    #Negative
  Scenario Outline: Get single resources with invalid data id
    Given Get single resources with invalid data id <id>
    When Send request get single list resources
    Then Status code should be 404

    Examples:
      | id |
      | 23 |
      | 24 |
      | 25 |