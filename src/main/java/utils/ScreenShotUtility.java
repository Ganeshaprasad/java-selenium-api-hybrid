package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtility  implements ITestListener {
    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        ScreenShotUtility.driver = driver;
    }

    public void onTestFailure(ITestResult result)
{
GeneralUtility generalUtility=new GeneralUtility();
    String dateTime = generalUtility.getDateAndTime();

    String testName = result.getName();
    TakesScreenshot screenShot = (TakesScreenshot) driver;
    File src = screenShot.getScreenshotAs(OutputType.FILE);
    File dest=new File("./screenshots/"+testName+" "+dateTime+".png");
    try {
        FileUtils.copyFile(src,dest);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}

}
