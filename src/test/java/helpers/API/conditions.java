package helpers.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helpers.API.apiUtility.dinamicEmail;

public class conditions {
    public static RequestSpecification request;
    public static void setupHeaders(){
        request = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }

    public static Response getListUsers(String endpoint){
        setupHeaders();
        return request.when().get(endpoint);
    }
    public static Response createNewUser(String endpoint){
        String first_name = "bruno";
        String last_name = "boy";
        String email = dinamicEmail();

        JSONObject payload = new JSONObject();
        payload.put("first_name", first_name);
        payload.put("last_name", last_name);
        payload.put("email", email);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }
    public static Response updateData(String endpoint, String user_id){
        String first_name = "bruno edit";
        String last_name = "von boy";
        String email = dinamicEmail();

        JSONObject payload = new JSONObject();
        payload.put("first_name", first_name);
        payload.put("last_name", last_name);
        payload.put("email", email);

        String finalEndpoint = endpoint + "/" + user_id;
        setupHeaders();
        return request.body(payload.toString()).when().put(finalEndpoint);
    }
    public static Response deleteUser(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }
    public static Response getUnregisteredUser(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().get(finalEndpoint);
    }
    public static Response createNewUserAbnormal(String endpoint) {
        String first_name = "yaya";
        String last_name = "yeye";
        String email = dinamicEmail();

        JSONObject payload = new JSONObject();
        payload.put("first_name", first_name);
        payload.put("last_name", last_name);
        payload.put("email", email);

        setupHeaders();
        return request
                .header("Authorization","Bearer bb51cfd397e59766aa807a30b85ee951e72aab8b833dd7d73702fd1b85eecb12")
                .body(payload.toString()).when().post(endpoint);
    }
    public static Response updateWithoutAuthorization(String endpoint, String user_id){
        String name = "doby update";
        String email = dinamicEmail();
        String gender = "male";
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("status", status);

        String finalEndpoint = endpoint + "/" + user_id;
        setupHeaders();
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }
    public static Response deleteUnauthorized(String endpoint, String user_id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }
}
