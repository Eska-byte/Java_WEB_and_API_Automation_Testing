package pages.WEB;

import helpers.WEB.webUtility;
import org.openqa.selenium.By;

public class loginPage extends webUtility {
    By username_box = By.id("user-name");
    By password_box = By.id("password");
    By loginButton = By.id("login-button");
    By error_message(String message) {
        return By.xpath("//*[contains(text(),'"+message+"')]");
    }

    public void goToLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }
    public void inputUsername(String username){
        driver.findElement(username_box).sendKeys(username);
    }
    public void inputPassword(String password){
        driver.findElement(password_box).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void validateErrormessage(String message){
        driver.findElement(error_message(message)).isDisplayed();
    }
}
