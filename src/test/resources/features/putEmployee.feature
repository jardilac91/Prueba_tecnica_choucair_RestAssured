Feature: Update an employee.
  As an user using the Dummy Rest API Example.
  I want to send a put request to the "update" endpoint.
  To update an employee in the service.

  Scenario Outline: update an employee.
    Given That the user can send requests Dummy Rest Api Example.
    When the user send a put request to the id "<id>" with name "<name>" salary "<salary>" and age "<age>".
    Then the user should see that the response returns the new name "<name>" salary "<salary>" age "<age>" and an Id.
    Examples:
    | id  | name    | salary  | age   |
    | 15  | Jorge   | 10.000  | 25    |