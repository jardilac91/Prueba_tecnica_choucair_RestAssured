Feature: Delete an employee.
  As an user using the Dummy Rest API Example.
  I want to send a delete request to the "delete" endpoint.
  To delete an employee in the service.

  Scenario Outline: delete an employee.
    Given That the user can send requests Dummy Rest Api Example.
    When the user send a delete request with the id "<id>".
    Then the user should see that the response returns the id "<id>" status "<status>" and message "<message>".
    Examples:
      | id  |  status   |               message                  |
      | 15  |  success  | Successfully! Record has been deleted  |