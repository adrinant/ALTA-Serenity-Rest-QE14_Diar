package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.CoreMatchers.equalTo;

public class DelayedResponseStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get delayed response with valid delay parameter {int}")
    public void getDelayedResponseValidDelay(int delay) {
        reqresAPI.delayedResponse(delay);
    }

    @When("Send request get delayed response")
    public void sendRequestGetDelayedResponse() {
        SerenityRest.when()
                .get(ReqresAPI.DELAYED_RESPONSE);
    }

    @And("Response body page should be {int} and data id {int} with email {string}")
    public void responseBodyPageShouldBeAndDataIdWithEmail(int page, int id, String email) {
        SerenityRest.and()
                .body(ReqresResponses.PAGE, equalTo(page))
                .body(ReqresResponses.DATA_ARRAY_ID, equalTo(id))
                .body(ReqresResponses.DATA_ARRAY_EMAIL, equalTo(email));
    }

    @Given("Get delayed response with invalid delay parameter {string}")
    public void getDelayedResponseWithInvalidDelayParameter(String delay) {
        reqresAPI.delayedResponseInvalid(delay);
    }
}
