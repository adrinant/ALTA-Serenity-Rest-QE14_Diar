package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class SingleUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with valid user id {int}")
    public void getSingleUserWithValidParameterPage(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when()
                .get(ReqresAPI.SINGLE_USER);
    }

    @Given("Get single user with invalid user id {int}")
    public void getSingleUserWithInvalidUserId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @Given("Get single user with invalid user id {string}")
    public void getSingleUserWithNonNumericId(String id) {
        reqresAPI.getSingleUserNonNumeric(id);
    }
}
