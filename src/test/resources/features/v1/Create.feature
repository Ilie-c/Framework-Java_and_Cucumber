Feature: Test cases for employee

  Test scripts for employee endpoint.

  @SmokeTest
    @RegresionTest
  Scenario Outline: Employ new Employee
    When the admin employs new employee: <name>, <salary> and <age>
    Then the status code is <statusCode>
    And the response contains the given data and an id
    Examples:
      | statusCode | name           | salary | age |
      | 201        | test_gk_unique | 123    | 23  |
