import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class IframeTest {
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_target";
    String acceptBtnId = "accept-choices";
    String btnLabel = "Run ❯";
    String externalFrameId = "iframeResult";
    String internalFrameId = "iframe_a";
    String expectedH1Text = "This page is displayed in an iframe";
    String expectedH2Text = "Iframe - Target for a Link";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public String findElText(By selector) {
        return driver.findElement(selector).getText();
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        WebElement acceptBtn = driver.findElement(By.id(acceptBtnId));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(acceptBtnId)));
        acceptBtn.click();
        driver.switchTo().frame(externalFrameId);
        String actualH2 = findElText(By.cssSelector("h2"));
        Assert.assertEquals(actualH2, expectedH2Text);
        driver.switchTo().frame(internalFrameId);
        String actualH1 = findElText(By.cssSelector("h1"));
        Assert.assertEquals(actualH1, expectedH1Text);
        driver.switchTo().defaultContent();
        Assert.assertEquals(findElText(By.id("runbtn")), btnLabel);
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}

