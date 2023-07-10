package automationApi.stepdefinitions;

import automationApi.config.makeAnApiRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static pruebaendpoint.utils.EmployeeApi.CREATE_EMPLOYEE;
import static pruebaendpoint.utils.createRequest.createJson;


public class stepdefinitionspost extends makeAnApiRequest {

    @When("the user send a post request with name {string} salary {string} and age {string}.")
    public void theUserSendAPostRequestWithNameSalaryAndAge(String name, String salary, String age) {
        actor.attemptsTo(
                Post.to(CREATE_EMPLOYEE).with(
                        request -> request.contentType(ContentType.JSON)
                                .body(createJson(name,salary,age))
                )
        );
    }

    @Then("the user should see that the response returns the name {string} salary {string} age {string} and an Id.")
    public void theUserShouldSeeThatTheResponseReturnsTheNameSalaryAgeAndAnId(String name, String salary, String age) {
        actor.should(
                seeThatResponse("The status code is",
                        response -> response.statusCode(200)),
                seeThatResponse("the data of body is: ",
                        response -> response.body("data.name", equalTo(name))
                                .body("data.salary", equalTo(salary))
                                .body("data.age", equalTo(age))
                )

        );
    }
}
