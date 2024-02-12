package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframePage {

    private String acceptBtnId = "accept-choices";
    private String externalFrameId = "iframeResult";
    private String internalFrameId = "iframe_a";
    private WebDriver driver;
    private WebDriverWait wait;

    public IframePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    private String findElText(By selector) {
        return driver.findElement(selector).getText();
    }

    private void switchToFrame(String frameId) {
        driver.switchTo().frame(frameId);
    }

    public void switchToExternalFrame() {
        switchToFrame(externalFrameId);
    }

    public void switchToInternalFrame() {
        switchToFrame(internalFrameId);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String findH1Text() {
        return findElText(By.cssSelector("h1"));
    }

    public String findH2Text() {
        return findElText(By.cssSelector("h2"));
    }

    public int returnSizeOfH2List() {
        return driver.findElements(By.cssSelector("h2")).size();
    }

    public String findRunBtnText() {
        return findElText(By.id("runbtn"));
    }

    public void acceptAlertBtn() {
        WebElement acceptBtn = driver.findElement(By.id(acceptBtnId));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(acceptBtnId)));
        acceptBtn.click();
    }
}
