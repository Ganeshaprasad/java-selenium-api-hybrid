package ui_test;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ui.utils.*;

import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;

    ChromeOptions cOptions;
    FirefoxOptions fOptions;
    public static Logger logger;

    @BeforeMethod(alwaysRun = true)
    @Parameters("baseurl")
    public void setUp(String baseurl) throws IOException {

        logger = Logger.getLogger("Java-Selenium-Api-Hybrid");
        PropertyConfigurator.configure("log4j.properties");
        cOptions = new ChromeOptions();
        fOptions=new FirefoxOptions();

        if (FileUtility.getBrowser().equals("chrome")) {
            if (FileUtility.isHeadLess()) {

                cOptions.addArguments("--headless");
                driver = new ChromeDriver(cOptions);
                logger.info("Chrome browser launched with out Head");
            } else {
                driver = new ChromeDriver();
                logger.info("Chrome browser launched with Head");
            }

        } else if (FileUtility.getBrowser().equals("firefox")) {
            if (FileUtility.isHeadLess()) {

                fOptions.addArguments("--headless");
                driver = new FirefoxDriver(fOptions);
                logger.info("Firefox browser launched with out Head");
            }else {
                driver=new FirefoxDriver();
                logger.info("Firefox browser launched with  Head");
            }
        }
        ScreenShotUtility.setDriver(driver);

        driver.get(baseurl);
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
