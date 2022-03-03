Feature: Test cases for employee

  Test scripts for employee endpoint.

  Background:
#    Given The demo application is up and running


  @SmokeTest
    @RegresionTest
  Scenario Outline: Get an employee by id
    When the user requests employee with id <id>
    Then the status code is <statusCode>
    And The details about that employee is returned
    Examples:
      | statusCode | id |
      | 200        | 1  |

  @RegresionTest
  Scenario Outline: Get an employee with nonexistent id
    When the user requests employee with id <id>
    Then the status code is <statusCode>
    And The response should be null
    Examples:
      | statusCode | id   |
      | 404        | 1000 |
      | 404        | abc  |
      | 404        | 1abc |

  @RegresionTest
  Scenario Outline: Get an employee with null/empty id
    When the user requests employee with id <id>
    Then the status code is <statusCode>
    And The response should be null
    Examples:
      | statusCode | id   |
      | 400        | Null |
      | 400        |      |
