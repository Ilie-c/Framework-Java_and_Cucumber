Feature: Test cases for employee

  Test scripts for employee endpoint.

  @SmokeTest
    @RegresionTest
  Scenario Outline: Remove an employee
    When the admin removes employee <id>
    Then the status code is <statusCode>
    And the delete response contains <sucesfull_message>
    Examples:
      | statusCode | id | sucesfull_message             |
      | 200        | 10 | successfully! deleted Records |

  @RegresionTest
  Scenario Outline: Remove an employee using non integer id
    When the admin removes employee <id>
    Then the status code is <statusCode>
    And the negative response contains <negative_message>
    Examples:
      | statusCode | id     | negative_message             |
      | 400        | string | fail! provide an existing id |

  @RegresionTest
  Scenario Outline: Remove an employee using null id
    When the admin removes employee <id>
    Then the status code is <statusCode>
    And the negative response contains <negative_message>
    Examples:
      | statusCode | id   | negative_message             |
      | 400        | null | fail! provide an existing id |