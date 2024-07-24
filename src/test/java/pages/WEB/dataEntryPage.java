package pages.WEB;

import helpers.WEB.webUtility;
import org.openqa.selenium.By;

public class dataEntryPage extends webUtility {
    By required_information_box = By.xpath("//*[@class='checkout_info']");
    By continue_button = By.id("continue");
    By error_warning(String warning){
        return By.xpath("//*[contains(text(),'"+warning+"')]");
    }
    By first_name_box = By.id("first-name");
    By last_name_box = By.id("last-name");
    By zip_code_box = By.id("postal-code");

    public void validateDataEntrypage(){
        driver.findElement(required_information_box).isDisplayed();
    }

    public void clickContinueButton(){
        driver.findElement(continue_button).click();
    }

    public void validateErrorWarning(String warning){
        driver.findElement(error_warning(warning)).isDisplayed();
    }

    public void inputFirstName(String firstName){
        driver.findElement(first_name_box).sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        driver.findElement(last_name_box).sendKeys(lastName);
    }
    public void inputZipCode(String zipCode){
        driver.findElement(zip_code_box).sendKeys(zipCode);
    }
}
