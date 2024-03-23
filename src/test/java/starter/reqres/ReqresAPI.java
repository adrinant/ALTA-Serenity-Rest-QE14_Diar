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

    @Step("Get single user with valid user id")
    public void getSingleUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get all list resources with valid parameter")
    public void getAllListResources() {
        //Saya isi get karena tidak ada precondition / parameter untuk /api/unknown
        SerenityRest.given()
                .get(LIST_RESOURCES);
    }

    @Step("Get single resources with valid data id")
    public void getSingleResources(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single resources with invalid data id")
    public void getSingleResourcesInvalid(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Update user with invalid JSON and valid user id")
    public void updateUserInvalidJsonValidId(File JSON, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("Update user with valid JSON {string} and invalid user id {int}")
    public void updateUserValidJsonInvalidId(File JSON, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(JSON);
    }

    @Step("Delete single user with valid user id")
    public void deleteSingleUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete single user with invalid user id")
    public void deleteSingleUserInvalidId(int id) {
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

}