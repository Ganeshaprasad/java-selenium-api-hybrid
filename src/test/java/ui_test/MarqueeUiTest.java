package ui_test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pom.MarqueePOM;

//@Listeners(ScreenShotUtility.class) --> no need to aad it to every class , we can add it globally by specifying in testng.xml
public class MarqueeUiTest extends BaseTest {
MarqueePOM marqueePOM;

@BeforeMethod(alwaysRun = true)
public void initializePageObject()
{

    logger.info("Driver initialised for Marquee POM");
    marqueePOM=new MarqueePOM(getDriver());

}
    @Test
    public void verifyThePresenceOfMarquee()
    {

        System.out.println(marqueePOM.checkPresenceOfElement());
       try {
           getDriver().findElement(By.xpath("//span[text()='Home Decor'")).click();
       }catch (Exception e) {

       }

       Assert.fail();
       // Assert.assertTrue(true);
    }
}
