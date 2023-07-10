package automationApi.stepdefinitions;

import automationApi.config.makeAnApiRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static pruebaendpoint.utils.EmployeeApi.API_URL;
import static pruebaendpoint.utils.EmployeeApi.GET_ALL_EMPLOYEES;
import static pruebaendpoint.utils.EmployeeApi.GET_EMPLOYEE;

public class stepdefinitionsget extends makeAnApiRequest {

    @Given("That the user can send requests Dummy Rest Api Example.")
    public void that_the_user_can_send_requests_dummy_rest_api_example() {
        sendRequests(API_URL);
    }

    @When("The user send a Get request to the endpoint.")
    public void the_user_send_a_get_request_to_the_endpoint() {
        actor.attemptsTo(
                Get.resource(GET_ALL_EMPLOYEES)
        );

    }
    @Then("The response received has a status 200,")
    public void the_response_received_has_a_status() {
        actor.should(
                seeThatResponse(
                        "The status code: ",
                        response -> response.statusCode(200))
        );


    }
    @And("The user receives the information about all employees")
    public void the_user_receives_the_information_about_all_employees() {
        // Write code here that turns the phrase above into concrete actions
        actor.should(
                seeThatResponse(
                        "The user obtains the list of the user and a message: ",
                        response -> response.body(
                                "message", equalTo("Successfully! All records has been fetched.")
                        )
                )
        );

    }

    @When("the user send a get request with an a id {string}.")
    public void theUserSendAGetRequestWithAnAIdId(String id) {
        actor.attemptsTo(
                Get.resource(String.format(GET_EMPLOYEE, id))
        );
    }

    @Then("the user get {string} of the employee and a status {string} with a message {string}.")
    public void theUserGetNameOfTheEmployeeAndAStatusStatusWithAMessageMessage(String name, String status, String message) {
        actor.should(
                seeThatResponse(
                        "The user obtains the information about the user",
                        response -> response.body("data.employee_name", equalTo(name))
                                .body("status", equalTo(status))
                                .body("message", equalTo(message))
                )
        );
    }



}


