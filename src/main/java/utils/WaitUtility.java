package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    private WebDriverWait webDriverWait;

    public boolean waitForVisibilityOfElement(WebDriver driver, int timeInSeconds, WebElement element)
    {
        webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        return webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
}
