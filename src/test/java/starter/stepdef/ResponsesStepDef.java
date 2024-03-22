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
        File jsonFile = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    //Tugas
    @And("Response body data id should be {}")
    public void responseBodyDataIdShouldBe(int id) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID, equalTo(id));
    }
}
