package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.IPresence;

import java.util.List;

public class MarqueePOM extends BasePOM implements IPresence {

    @FindBy(xpath = "//h1")
    private List<WebElement> link;
public MarqueePOM(WebDriver driver)
{
    super(driver);

}
public boolean checkPresenceOfElement(){
    WebElement linkElement = link.get(0);
    boolean ele = waitUtility.waitForVisibilityOfElement(driver, 10, linkElement);

return ele;
}
}
