package helpers.WEB;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class webUtility {
    public static WebDriver driver;

    public static void getDriver(){
        ChromeOptions chrome = new ChromeOptions();

//        chrome.addArguments("--headless");
        chrome.addArguments("--no-sandbox");
        chrome.addArguments("--disable-dev-shm-usage");
        chrome.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.saucedemo.com/");
    }
    public static void quitDriver() {
        driver.quit();
    }
}
