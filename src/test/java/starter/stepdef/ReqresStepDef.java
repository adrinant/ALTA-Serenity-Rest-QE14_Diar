package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithParameterPage(int page){
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when()
                .get(ReqresAPI.LIST_USERS);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    //Scenario 2
    @Given("Create user with valid JSON {string}")
    public void createUserWithValidJSON(String JSON){
        File jsonFile = new File(Constants.REQ_BODY+JSON);
        reqresAPI.postCreateUser(jsonFile);
    }

    @When("Send request create new user")
    public void sendRequestCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.CREATE_USER);
    }
}
