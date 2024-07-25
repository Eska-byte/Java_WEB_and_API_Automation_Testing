package webUIstepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WEB.cartPage;

public class cartStep {
    cartPage CartPage;
    public cartStep(){
        this.CartPage = new cartPage();
    }

    @Then("user will direct to cart page")
    public void userWillDirectToCartPage() {
        CartPage.validateCartpage();
    }

    @When("user click checkout button")
    public void userClickCheckoutButton() {
        CartPage.clickCheckoutButton();
    }

    @And("user remove item from cart")
    public void userRemoveItemFromCart() {
        CartPage.clickRemoveButton();
    }
}
