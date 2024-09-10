package ui_test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.page_object_repository.MarqueePOM;
import ui.utils.GeneralUtility;
import ui.utils.ScreenShotUtility;

//@Listeners(ScreenShotUtility.class) --> no need to aad it to every class , we can add it globally by specifying in testng.xml
public class MarqueeUiTest extends BaseTest {
MarqueePOM marqueePOM;

@BeforeMethod(alwaysRun = true)
public void initializePageObject()
{

    logger.info("Driver initialised for Marquee POM");
    marqueePOM=new MarqueePOM(driver);

}
    @Test
    public void verifyThePresenceOfMarquee()
    {

        System.out.println(marqueePOM.checkPresenceOfElement());

       Assert.fail();
       // Assert.assertTrue(true);
    }
}
