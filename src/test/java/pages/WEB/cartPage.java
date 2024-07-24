package pages.WEB;

import helpers.WEB.webUtility;
import org.openqa.selenium.By;

public class cartPage extends webUtility {
    By remove_button_cart = By.xpath("(//*[text()='Remove'])[1]");
    By checkout_button = By.id("checkout");

    public void validateCartpage(){
        driver.findElement(checkout_button).isDisplayed();
    }
    public void clickRemoveButton(){
        driver.findElement(remove_button_cart).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(checkout_button).click();
    }
}
