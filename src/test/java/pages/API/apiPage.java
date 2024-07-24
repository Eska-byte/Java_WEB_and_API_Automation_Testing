package pages.API;

import helpers.API.apiUtility;
import helpers.API.endpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helpers.API.conditions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class apiPage {
    String setupURL, setupID, userID;
    Response resp;

    public void prepareURL(String url){
        switch (url){
            case "GET_list_users":
                setupURL = endpoint.GET_list_users;
                break;
            case "POST_new_user":
                setupURL = endpoint.POST_new_user;
                break;
            case "PUT_update_data":
                setupURL = endpoint.PUT_update_data;
                break;
            case "DELETE_data":
                setupURL = endpoint.DELETE_data;
                break;
            case "GET_unregistered_user":
                setupURL = endpoint.GET_unregistered_user;
                break;
            case "POST_wrong_format":
                setupURL = endpoint.POST_wrong_format;
                break;
            case "PATCH_unauthorized":
                setupURL = endpoint.PATCH_unauthorized;
                break;
            case "DELETE_unauthorized":
                setupURL = endpoint.DELETE_unauthorized;
                break;
            default:
                System.out.println("input valid url");
        }
    }
    public void hitAPIrequestGET(){
        resp = getListUsers(setupURL);
    }
    public void verificationStatusCode(int status_code){
        assertThat(resp.statusCode()).isEqualTo(status_code);
    }
    public void verificationResponseBodyGETData(){

        List<Object> id = resp.jsonPath().getList("id");
        List<Object> name = resp.jsonPath().getList("name");
        List<Object> email = resp.jsonPath().getList("email");
        List<Object> gender = resp.jsonPath().getList("gender");
        List<Object> status = resp.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("male", "female");
        assertThat(status.get(0)).isIn("active", "inactive");

        userID = id.get(0).toString();
    }
    public void verificationResponseJsonWithJSONSchema(String filename){
        File JSONfile = apiUtility.JSONSchemaFile(filename);
        resp.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONfile));
    }
    public void hitAPIRequestPOST(){
        resp = createNewUser(setupURL);
    }
    public void verificationResponseBodyPOSTCreateData(){
        JsonPath jsonPathEvaluator = resp.jsonPath();
        String id = jsonPathEvaluator.get("id").toString();
        String email = jsonPathEvaluator.get("email");
        String first_name = jsonPathEvaluator.get("first_name");
        String last_name = jsonPathEvaluator.get("last_name");

        assertThat(id).isNotNull();
        assertThat(email).isNotNull();
        assertThat(first_name).isNotNull();
        assertThat(last_name).isNotNull();

        setupID = id;
    }
    public void hitAPIRequestPUT(){
        resp = updateData(setupURL, setupID);
    }
    public void verificationResponseBodyPUTUpdateData(){
        JsonPath jsonPathEvaluator = resp.jsonPath();
        String email = jsonPathEvaluator.get("email");
        String first_name = jsonPathEvaluator.get("first_name");
        String last_name = jsonPathEvaluator.get("last_name");

        assertThat(email).isNotNull();
        assertThat(first_name).isNotNull();
        assertThat(last_name).isNotNull();
    }
    public void hitAPIRequestDELETE(){
        resp = deleteUser(setupURL, setupID);
    }
    public void hitAPIRequestGETUnregistered_user(){
        resp = getUnregisteredUser(setupURL, setupID);
    }
    public void hitAPIRequestPOSTWithDataAbnormal(){
        resp = createNewUserAbnormal(setupURL);
    }

    public void hitAPIRequestPATCHUnauthorized(){
        resp = updateWithoutAuthorization(setupURL, userID);
    }
    public void hitAPIRequestDELETEunauthorized(){
        resp = deleteUnauthorized(setupURL, userID);
    }
}
