package webUIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WEB.loginPage;

public class loginStep {
    loginPage LoginPage;
    public loginStep(){
        this.LoginPage = new loginPage();
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        LoginPage.goToLoginPage();
    }

    @When("user input username textbox with {string}")
    public void userInputUsernameTextboxWith(String username) {
        LoginPage.inputUsername(username);
    }

    @And("user input password textbox with {string}")
    public void userInputPasswordTextboxWith(String password) {
        LoginPage.inputPassword(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        LoginPage.clickLoginButton();
    }

    @Then("user will see error message {string}")
    public void userWillSeeErrorMessage(String message) {
        LoginPage.validateErrormessage(message);
    }

}
