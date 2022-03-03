Feature: Test cases for employee

  Test scripts for employee endpoint.

  @SmokeTest
    @RegresionTest
  Scenario Outline: Remove an existing employee
    When The admin removes employee <id>
    Then the status code is <statusCode>
    And the response contains message <message>
    Examples:
      | statusCode | id | message                       |
      | 200        | 10 | successfully! deleted Records |