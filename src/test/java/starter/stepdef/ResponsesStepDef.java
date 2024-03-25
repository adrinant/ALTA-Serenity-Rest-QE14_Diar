package starter.stepdef;

import io.cucumber.java.en.And;
import net.serenitybdd.rest.SerenityRest;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponsesStepDef {
    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.and()
                .body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA + json);
        SerenityRest.and()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    //Tugas
    @And("Response body data id should be id {int} and email {string}")
    public void responseBodyDataIdShouldBe(int id, String email) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID, equalTo(id))
                .body(ReqresResponses.DATA_EMAIL, equalTo(email));
    }

    @And("Response body data id should be id {int}")
    public void responseBodyIdShouldBeId(int id) {
        SerenityRest.and()
                .body(ReqresResponses.SINGLE_RESOURCES_DATA_ID, equalTo(id));
    }

    @And("Response body should {string}")
    public void responseBodyShould(String errorMessage) {
        SerenityRest.and()
                .body(ReqresResponses.ERROR_MESSAGE, equalTo(errorMessage));
    }

    @And("Response body id should be id {int}")
    public void responseBodyDataIdShouldBeId(int id) {
        SerenityRest.and()
                .body(ReqresResponses.ID, equalTo(id));
    }

}
