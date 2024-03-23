package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete single user with valid user id {int}")
    public void deleteSingleUserWithValidUserId(int id) {
        reqresAPI.deleteSingleUser(id);
    }

    @When("Send request delete single user")
    public void sendRequestDeleteSingleUser() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);
    }

    @Given("Delete single user with invalid user id {int}")
    public void deleteSingleUserWithInvalidUserId(int id) {
        reqresAPI.deleteSingleUserInvalidId(id);
    }
}
