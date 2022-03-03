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

  @RegresionTest
  Scenario Outline: Employ new Employee with unaccepted values
    When the admin employs new employee: <name>, <salary> and <age>
    Then the status code is <statusCode>
    And the response should be an error
    Examples:
      | statusCode | name            | salary | age    |
      | 400        | test_uav_unique | string | 23     |
      | 400        | test_uav_unique | 123    | string |

  @RegresionTest
  Scenario Outline: Employ new Employee with emply/null values
    When the admin employs new employee: <name>, <salary> and <age>
    Then the status code is <statusCode>
    And the response should be an error
    Examples:
      | statusCode | name            | salary | age  |
      | 400        | null            | 123    | 23   |
      | 400        |                 | 123    | 23   |
      | 400        | test_env_unique |        | 23   |
      | 400        | test_env_unique | null   | 23   |
      | 400        | test_env_unique | 123    |      |
      | 400        | test_env_unique | 123    | null |
