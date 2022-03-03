Feature: Test cases for employee

  Test scripts for employee endpoint.

  @SmokeTest
    @RegresionTest
  Scenario Outline: Employ new Employee
    When the admin changes data for employee <id> with <name>, <salary> and <age>
    Then the status code is <statusCode>
    And the response contains the new data
#    And the employee is updated in the application.
    Examples:
      | statusCode | id | name               | salary | age |
      | 200        | 10 | test_update_unique | 321    | 80  |

  @RegresionTest
  Scenario Outline: Update employee without every required item
    When the admin changes data for employee <id> with <name>, <salary> and <age>
    Then the status code is <statusCode>
#    And the response returns an error about null object
    Examples:
      | statusCode | id | name                    | salary | age  |
      | 400        | 10 | test_null_update_unique | 321    | null |
      | 400        | 10 | test_null_update_unique | null   | 123  |
      | 400        | 10 | null                    | 321    | 123  |

  @RegresionTest
  Scenario Outline: Update employee with more items
    When the admin adds data for employee <id> with <name>, <salary>, <age> and <unique_nonexistent>
    Then the status code is <statusCode>
#    And the response returns an error about too many items
    Examples:
      | statusCode | id | name                   | salary | age | unique_nonexistent |
      | 400        | 10 | negative_update_extend | 321    | 123 | string_unique      |

  @RegresionTest
  Scenario Outline: Update employee with one less field
    When the admin adds partial data for employee <id> with <name> and <age>
    Then the status code is <statusCode>
#    And the response returns an error about too less items
    Examples:
      | statusCode | id | name                   | age |
      | 400        | 10 | negative_update_extend | 123 |

  @RegresionTest
  Scenario Outline: Update employee with contrary types
    When the admin changes data for employee <id> with <name>, <salary> and <age>
    Then the status code is <statusCode>
#    And the response returns an error about contrary types
    Examples:
      | statusCode | id | name                     | salary        | age           |
      | 400        | 10 | negative_update_contrary | string_unique | 123           |
      | 400        | 10 | 123                      | 321           | 123           |
      | 400        | 10 | negative_update_contrary | 321           | string_unique |
      | 400        | 10 | integer_123              | 321           | string_unique |
