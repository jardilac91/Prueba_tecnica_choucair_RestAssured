package automationApi.stepdefinitions;

import automationApi.config.makeAnApiRequest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.rest.interactions.Delete;


import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static pruebaendpoint.utils.EmployeeApi.DELETE_EMPLOYEE;
import static pruebaendpoint.utils.createRequest.createJson;


public class stepdefinitionsdelete extends makeAnApiRequest {

    @When("the user send a delete request with the id {string}.")
    public void theUserSendADeleteRequestWithTheId(String id) {
        actor.attemptsTo(
                Delete.from(String.format(DELETE_EMPLOYEE, id))
        );
    }

    @Then("the user should see that the response returns the id {string} status {string} and message {string}.")
    public void theUserShouldSeeThatTheResponseReturnsTheNewNameSalaryAgeAndAnId(String id, String status, String message) {
        actor.should(
                seeThatResponse("The status code is 200",
                        response -> response.statusCode(200)),
                seeThatResponse(String.format(
                        "the id, status and message are equals to: %s, %s, %s", id, status, message),
                        response -> response.body("data", equalTo(id))
                                .body("status", equalTo(status))
                                .body("message", equalTo(message))
                )

        );
    }
}

