package ui_test;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ui.utils.*;

import java.io.IOException;

public class BaseTest
{

    public static WebDriver driver;
   private FileUtility fileUtility;

   public static Logger logger;

    @BeforeMethod(alwaysRun = true)
    @Parameters("baseurl")
    public void setUp(String baseurl) throws IOException {

        logger=Logger.getLogger("Java-Selenium-Api-Hybrid");
        PropertyConfigurator.configure("log4j.properties");


        fileUtility= new FileUtility();
        if (fileUtility.readDataFromPropertyFile("config.properties", "browser").equals("chrome")) {
            driver = new ChromeDriver();
            logger.info("Chrome browser launched");
        } else if (fileUtility.readDataFromPropertyFile("config.properties", "browser").equals("firefox")) {
            driver=new FirefoxDriver();
            logger.info("Firefox browser launched");
        }
        ScreenShotUtility.setDriver(driver);

        driver.get(baseurl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
