package ui_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.utils.GeneralUtility;

import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;
    public GeneralUtility generalUtility= new GeneralUtility();


    @BeforeMethod
    public void setUp() throws IOException {
        if (generalUtility.readDataFromPropertyFile("config.properties", "browser").equals("chrome")) {
            driver = new ChromeDriver();
        } else if (generalUtility.readDataFromPropertyFile("config.properties", "browser").equals("firefox")) {
            driver=new FirefoxDriver();
        }
        driver.get("https://www.shutterfly.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
