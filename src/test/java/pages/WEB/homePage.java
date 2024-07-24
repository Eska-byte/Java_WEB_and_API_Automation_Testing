package pages.WEB;

import helpers.WEB.webUtility;
import org.openqa.selenium.By;

public class homePage extends webUtility {
    By product_title = By.xpath("(//*[@data-test='inventory-item-name'])[1]");
    By product_image = By.xpath("(//*[@class='inventory_item_img'])[1]");
    By addToCart_button = By.xpath("(//*[text()='Add to cart'])[1]");

    By iconCart(String item){
        return By.xpath("//span[@class='shopping_cart_badge'][contains(text(),'"+item+"')]");
    }
    By remove_button_home = By.xpath("(//*[text()='Remove'])[1]");
    By cart_icon = By.xpath("//*[@class='shopping_cart_link']");

    public void validateHomepage() {
        driver.findElement(product_title).isDisplayed();
        driver.findElement(product_image).isDisplayed();
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCart_button).click();
    }

    public void validateNumberOfItems(String item){
        driver.findElement(iconCart(item)).isDisplayed();

    }
    public void clickRemove(){
        driver.findElement(remove_button_home).click();
    }

    public void clickCartIcon(){
        driver.findElement(cart_icon).click();
    }
}
