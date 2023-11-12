package sharedData;

import logger.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import sharedData.browser.BrowserFactory;

@Getter
public class SharedData {

    private WebDriver driver;

    public void initializeDriver(){
        driver = new BrowserFactory().getBrowserDriver();
    }

    public void quitDriver(){
        driver.quit();
        LoggerUtility.info("The driver is closed with success");
    }
}
