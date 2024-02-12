package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;


public class Hooks {
    protected static final String BASE_URL = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_target";
    protected WebDriver driver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
