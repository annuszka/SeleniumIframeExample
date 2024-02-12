import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Hooks {
    private static final String BASE_URL = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_target";
    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.get(BASE_URL);
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
