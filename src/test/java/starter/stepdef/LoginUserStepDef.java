package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("User login with valid JSON {string}")
    public void userLoginWithValidJSON(String JSON) {
        File jsonFile = new File(Constants.REQ_BODY + JSON);
        reqresAPI.userLogin(jsonFile);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when()
                .post(ReqresAPI.USER_LOGIN);
    }

    @Given("User login with invalid JSON {string}")
    public void userLoginWithInvalidJson(String JSON) {
        File jsonFile = new File(Constants.REQ_BODY + JSON);
        reqresAPI.userLogin(jsonFile);
    }
}
