package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.utils.*;
import utils.*;

public class BasePOM  {

        protected WebDriver driver;
        protected GeneralUtility generalUtility;
        protected FileUtility fileUtility;
        protected ModalUtility modalUtility;
        protected WaitUtility waitUtility;
    protected ScreenShotUtility screenShotUtility;

        public BasePOM(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            this.generalUtility = new GeneralUtility();
            this.fileUtility = new FileUtility();
            this.modalUtility = new ModalUtility();
            this.waitUtility = new WaitUtility();
           // this.screenShotUtility= new ScreenShotUtility(driver);
        }
    }

