Feature: Get information about employees.

  Scenario: Get all employees information.
    Given That the user can send requests Dummy Rest Api Example.
    When The user send a Get request to the endpoint.
    Then The response received has a status 200,
    And The user receives the information about all employees

  Scenario Outline: Get the information about a employee.
    Given That the user can send requests Dummy Rest Api Example.
    When the user send a get request with an a id "<id>".
    Then the user get "<name>" of the employee and a status "<status>" with a message "<message>".
    Examples:
      | id  | name            | status   | message                                       |
      | 1   | Tiger Nixon     | success  | Successfully! Record has been fetched.        |
      | 30  | null            | error    | Employee not found                            |

