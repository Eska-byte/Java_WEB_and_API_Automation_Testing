package webUIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.WEB.dataEntryPage;

public class dataEntryStep {
    dataEntryPage DataEntryPage;
    public dataEntryStep(){
        this.DataEntryPage = new dataEntryPage();
    }

    @Then("user direct to data entry page")
    public void userDirectToDataEntryPage() {
        DataEntryPage.validateDataEntrypage();
    }

    @And("user click continue button")
    public void userClickContinueButton() {
        DataEntryPage.clickContinueButton();
    }

    @Then("user will see error warning {string}")
    public void userWillSeeErrorWarning(String warning) {
        DataEntryPage.validateErrorWarning(warning);
    }

    @And("user input first name textbox with {string}")
    public void userInputFirstNameTextboxWith(String firstName) {
        DataEntryPage.inputFirstName(firstName);
    }

    @And("user input last name textbox with {string}")
    public void userInputLastNameTextboxWith(String lastName) {
        DataEntryPage.inputLastName(lastName);
    }

    @And("user input zip code textbox with {string}")
    public void userInputZipCodeTextboxWith(String zipCode) {
        DataEntryPage.inputZipCode(zipCode);
    }
}
