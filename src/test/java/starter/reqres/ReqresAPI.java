package starter.reqres;

import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String LIST_USERS = Constants.BASE_URL + "/api/users?page={page}";
    public static String CREATE_USER = Constants.BASE_URL + "/api/users";
    public static String UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String LIST_RESOURCES = Constants.BASE_URL + "/api/unknown";
    public static String SINGLE_LIST_RESOURCES = Constants.BASE_URL + "/api/unknown/{id}";
    public static String USER_LOGIN = Constants.BASE_URL + "/api/login";
    public static String REGISTER = Constants.BASE_URL + "/api/register";
    public static String DELAYED_RESPONSE = Constants.BASE_URL + "/api/users?delay={delay}";

    @Step("Get list user with valid parameter page")
    public void getListUsers(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Post create user with valid JSON")
    public void postCreateUser(File JSON) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("Update user with valid JSON user id")
    public void putUpdateUser(int id, File JSON) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("Delete user with valid user id")
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single user")
    public void getSingleUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single user non-numeric id")
    public void getSingleUserNonNumeric(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get all list resources with valid parameter")
    public void getAllListResources() {
        //Saya isi get karena tidak ada precondition / parameter untuk /api/unknown
        SerenityRest.given()
                .get(LIST_RESOURCES);
    }

    @Step("Get single resources")
    public void getSingleResources(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Update user")
    public void updateUser(File JSON, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("Delete single user")
    public void deleteSingleUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("User login")
    public void userLogin(File JSON) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("Register user")
    public void registerUser(File JSON) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("Get delayed response with valid delay parameter")
    public void delayedResponse(int param) {
        SerenityRest.given()
                .pathParam("delay", param);
    }

    @Step("Get delayed response with invalid delay parameter")
    public void delayedResponseInvalid(String param) {
        SerenityRest.given()
                .pathParam("delay", param);
    }

}