Feature: Test cases for employee

  Test scripts for employee endpoint.

  @SmokeTest @RegresionTest
  Scenario: Get all employees
    When the user requests all employees
    Then the status code is 200
    And a list of employees is returned
    And the list is returned as "Employees" json schema

