package sharedData;

import loggerUtility.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import sharedData.browser.BrowserFactory;

@Getter
public class SharedData {

    private WebDriver driver;

    public void initializeDriver(){
        driver = new BrowserFactory().createBrowserDriver();
        LoggerUtility.info("The driver is opened with success");
    }

    public void quitDriver(){
        driver.quit();
        LoggerUtility.info("The driver is closed with success");
    }
}
