package starter.stepdef;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Update user with invalid JSON {string} and valid user id {int}")
    public void updateUserWithInvalidJSONAndValidUserId(String JSON, int id) {
        File jsonFile = new File(Constants.REQ_BODY + JSON);
        reqresAPI.updateUser(jsonFile, id);
    }

    @Given("Update user with valid JSON {string} and invalid user id {int}")
    public void updateUserWithValidJSONAndInvalidUserId(String JSON, int id) {
        File jsonFile = new File(Constants.REQ_BODY + JSON);
        reqresAPI.updateUser(jsonFile, id);
    }
}
