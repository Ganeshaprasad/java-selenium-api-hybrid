package ui_test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pom.MarqueePOM;

public class ResponsiveBannerTest extends BaseTest {
    MarqueePOM marqueePOM;
    @BeforeMethod(alwaysRun = true)
    public void initializePageObject()
    {

        logger.info("Driver initialised for Marquee POM");
        marqueePOM=new MarqueePOM(getDriver());

    }
    @Test
    public void responsiveBanner()
    {
        Assert.fail();
    }
}
