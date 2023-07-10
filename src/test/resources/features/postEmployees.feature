Feature: Create an employee.
  As an user using the Dummy Rest API Example.
  I want to send a post request to the endpoint create.
  To create an employee in the service.

  Scenario Outline: Create an employee.
    Given That the user can send requests Dummy Rest Api Example.
    When the user send a post request with name "<name>" salary "<salary>" and age "<age>".
    Then the user should see that the response returns the name "<name>" salary "<salary>" age "<age>" and an Id.
    Examples:
      | name    | salary  | age   |
      | Jorge   | 10.000  | 25    |