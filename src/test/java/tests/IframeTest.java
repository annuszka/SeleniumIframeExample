package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IframePage;


public class IframeTest extends Hooks {
    private IframePage iframePage;
    String btnLabel = "Run ❯";
    String expectedH1Text = "This page is displayed in an iframe";
    String expectedH2Text = "Iframe - Target for a Link";

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        driver = chooseDriver(browser);
        driver.get(BASE_URL);
        iframePage = new IframePage(driver);
    }

    @Test
    public void test() {
        iframePage.acceptAlertBtn();
        //Check H2 cannot be accessed from outside of the ExternalFrame
        Assert.assertEquals(iframePage.returnSizeOfH2List(), 0);

        iframePage.switchToExternalFrame();
        String actualH2 = iframePage.findH2Text();
        Assert.assertEquals(actualH2, expectedH2Text);

        iframePage.switchToInternalFrame();
        String actualH1 = iframePage.findH1Text();
        Assert.assertEquals(actualH1, expectedH1Text);

        iframePage.switchToDefaultContent();
        Assert.assertEquals(iframePage.findRunBtnText(), btnLabel);
    }
}

