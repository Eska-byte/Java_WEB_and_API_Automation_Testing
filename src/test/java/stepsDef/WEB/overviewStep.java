package stepsDef.WEB;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.WEB.overviewPage;

public class overviewStep {
    overviewPage OverviewPage;
    public overviewStep(){
        this.OverviewPage = new overviewPage();
    }

    @Then("user will direct to overview page")
    public void userWillDirectToOverviewPage() {
        OverviewPage.validateOverviewpage();
    }

    @And("user click finish button")
    public void userClickFinishButton() {
        OverviewPage.clickFinishButton();
    }

    @Then("user will receive thank you message {string}")
    public void userWillReceiveThankYouMessage(String message) {
        OverviewPage.validateThankyouMessage(message);
    }
}
