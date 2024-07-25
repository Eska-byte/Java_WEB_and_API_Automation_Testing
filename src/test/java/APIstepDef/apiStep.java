package APIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.API.apiPage;

public class apiStep {
    apiPage apiTest;
    public apiStep(){
        this.apiTest = new apiPage();
    }

    @Given("prepare URL {string}")
    public void prepareURL(String url) {
        apiTest.prepareURL(url);
    }
    @And("hit API request GET")
    public void hitAPIrequestGET() {
        apiTest.hitAPIrequestGET();
    }
    @Then("verification status code {int}")
    public void verificationStatusCode(int status_code) {
        apiTest.verificationStatusCode(status_code);
    }
    @Then("verification response body GET data")
    public void verificationResponseBodyGETData() {
        apiTest.verificationResponseBodyGETData();
    }
    @Then("verification response json with JSON Schema {string}")
    public void verificationResponseJsonWithJSONSchema(String filename) {
        apiTest.verificationResponseJsonWithJSONSchema(filename);
    }
    @And("hit API request POST")
    public void hitAPIRequestPOST() {
        apiTest.hitAPIRequestPOST();
    }
    @Then("verification response body POST create data")
    public void verificationResponseBodyPOSTCreateData() {
        apiTest.verificationResponseBodyPOSTCreateData();
    }
    @And("hit API request PUT")
    public void hitAPIRequestPUT() {
        apiTest.hitAPIRequestPUT();
    }
    @Then("verification response body PUT update data")
    public void verificationResponseBodyPUTUpdateData() {
        apiTest.verificationResponseBodyPUTUpdateData();
    }
    @And("hit API request DELETE")
    public void hitAPIRequestDELETE() {
        apiTest.hitAPIRequestDELETE();
    }
    @And("hit API request GET unregistered_user")
    public void hitAPIRequestGETUnregistered_user() {
        apiTest.hitAPIRequestGETUnregistered_user();
    }

    @And("hit API request POST data abnormal")
    public void hitAPIRequestPOSTDataabnormal() {
        apiTest.hitAPIRequestPOSTWithDataAbnormal();
    }

    @Then("hit API request PATCH unauthorized")
    public void hitAPIRequestPATCHUnauthorized() {
        apiTest.hitAPIRequestPATCHUnauthorized();
    }

    @And("hit API request DELETE unauthorized")
    public void hitAPIRequestDELETEunauthorized() {
        apiTest.hitAPIRequestDELETEunauthorized();
    }
}
