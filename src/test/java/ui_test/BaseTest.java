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
import utils.FileUtility;
import utils.ScreenShotUtility;

import java.io.IOException;

public class BaseTest {

    // ThreadLocal for WebDriver to ensure each test runs in its own thread
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    ChromeOptions cOptions;
    FirefoxOptions fOptions;
    public static Logger logger;

    public static WebDriver getDriver() {
        return driver.get();  // Returns the WebDriver instance for the current thread
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("baseurl")
    public void setUp(String baseurl) throws IOException {
        // Initialize logger
        logger = Logger.getLogger("Java-Selenium-Api-Hybrid");
        PropertyConfigurator.configure("log4j.properties");

        // Initialize browser options
        cOptions = new ChromeOptions();
        fOptions = new FirefoxOptions();

        // Select browser based on configuration
        if (FileUtility.getBrowser().equals("chrome")) {
            if (FileUtility.isHeadLess()) {
                cOptions.addArguments("--headless");
                driver.set(new ChromeDriver(cOptions));  // Initialize WebDriver for this thread
                logger.info("Chrome browser launched in headless mode");
            } else {
                driver.set(new ChromeDriver());  // Initialize WebDriver for this thread
                logger.info("Chrome browser launched with GUI");
            }
        } else if (FileUtility.getBrowser().equals("firefox")) {
            if (FileUtility.isHeadLess()) {
                fOptions.addArguments("--headless");
                driver.set(new FirefoxDriver(fOptions));  // Initialize WebDriver for this thread
                logger.info("Firefox browser launched in headless mode");
            } else {
                driver.set(new FirefoxDriver());  // Initialize WebDriver for this thread
                logger.info("Firefox browser launched with GUI");
            }
        }

        // Set driver for ScreenShotUtility
        ScreenShotUtility.setDriver(getDriver());

        // Open the specified URL
        getDriver().get(baseurl);
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver and remove it from ThreadLocal storage
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();  // Remove the WebDriver instance for the current thread
        }
    }
}
