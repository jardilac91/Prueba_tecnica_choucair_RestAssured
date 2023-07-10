package automationApi.stepdefinitions;

import automationApi.config.makeAnApiRequest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static pruebaendpoint.utils.EmployeeApi.UPDATE_EMPLOYEE;
import static pruebaendpoint.utils.createRequest.createJson;


public class stepdefinitionsput extends makeAnApiRequest {

    @When("the user send a put request to the id {string} with name {string} salary {string} and age {string}.")
    public void theUserSendAPutRequestWithNameSalaryAndAge(String id, String name, String salary, String age) {
        actor.attemptsTo(
                Put.to(String.format(UPDATE_EMPLOYEE, id)).with(
                        request -> request.contentType(ContentType.JSON)
                                .body(createJson(name,salary,age))
                )
        );
    }

    @Then("the user should see that the response returns the new name {string} salary {string} age {string} and an Id.")
    public void theUserShouldSeeThatTheResponseReturnsTheNewNameSalaryAgeAndAnId(String name, String salary, String age) {
        actor.should(
                seeThatResponse("The status code is 200",
                        response -> response.statusCode(200)),
                seeThatResponse(String.format("the name, salary and age are equals to: %s, %s, %s", name, salary, age),
                        response -> response.body("data.name", equalTo(name))
                                .body("data.salary", equalTo(salary))
                                .body("data.age", equalTo(age))
                )

        );
    }
}


