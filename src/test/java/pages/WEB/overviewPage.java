package pages.WEB;

import helpers.WEB.webUtility;
import org.openqa.selenium.By;

public class overviewPage extends webUtility {
    By info_payment = By.xpath("(//*[@class='summary_info_label'])[1]");
    By info_shipping = By.xpath("(//*[@class='summary_info_label'])[2]");
    By finish_button = By.id("finish");
    By thankyou_message(String warning){
        return By.xpath("//*[contains(text(),'"+warning+"')]");
    }

    public void validateOverviewpage(){
        driver.findElement(info_payment).isDisplayed();
        driver.findElement(info_shipping).isDisplayed();
    }

    public void clickFinishButton(){
        driver.findElement(finish_button).click();
    }

    public void validateThankyouMessage(String message){
        driver.findElement(thankyou_message(message)).isDisplayed();
    }
}
