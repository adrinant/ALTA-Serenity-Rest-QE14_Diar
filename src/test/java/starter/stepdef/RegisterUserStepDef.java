package starter.stepdef;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Register user with valid JSON {string}")
    public void registerUserWithValidJSON(String JSON) {
        File jsonFile = new File(Constants.REQ_BODY + JSON);
        reqresAPI.registerUser(jsonFile);
    }

    @When("Send request register user")
    public void sendRequestRegisterUser() {
        SerenityRest.when()
                .post(ReqresAPI.REGISTER);
    }

    @Given("Register user with invalid JSON {string}")
    public void registerUserWithInvalidJSON(String JSON) {
        File jsonFile = new File(Constants.REQ_BODY + JSON);
        reqresAPI.registerUser(jsonFile);
    }


}
