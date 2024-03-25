package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class ListResourcesStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get all list resources with valid parameter")
    public void getAllListResourcesWithValidParameter() {
        reqresAPI.getAllListResources();
    }


    @When("Send request get all list resources")
    public void sendRequestGetAllListResources() {
        SerenityRest.when()
                .get(ReqresAPI.LIST_RESOURCES);
    }

    @Given("Get single resources with valid data id {int}")
    public void getSingleResourcesWithValidDataId(int id) {
        reqresAPI.getSingleResources(id);
    }

    @When("Send request get single list resources")
    public void sendRequestGetSingleListResources() {
        SerenityRest.when()
                .get(ReqresAPI.SINGLE_LIST_RESOURCES);
    }


    @Given("Get single resources with invalid data id {int}")
    public void getSingleResourcesWithInvalidDataId(int id) {
        reqresAPI.getSingleResources(id);
    }


}
