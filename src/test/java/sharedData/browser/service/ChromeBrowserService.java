package sharedData.browser.service;

import logger.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sharedData.browser.service.BrowserService;
import xmlFile.xmlNode.DriverConfig;

import java.time.Duration;

@Getter
public class ChromeBrowserService implements BrowserService {

    private WebDriver driver;

    @Override
    public void openBrowser(DriverConfig driverConfig) {
        ChromeOptions options = (ChromeOptions) getBrowserOptions(driverConfig);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(driverConfig.url);
        LoggerUtility.info("The driver is opened with success");
    }

    @Override
    public Object getBrowserOptions(DriverConfig driverConfig) {
        ChromeOptions options = new ChromeOptions();
        if ((driverConfig.headless)) {
            options.addArguments("--headless=new");
        }
        options.addArguments(driverConfig.gpu);
        options.addArguments(driverConfig.resolution);
        options.addArguments(driverConfig.sandbox);
        options.addArguments(driverConfig.infoBars);
        options.addArguments(driverConfig.extensions);
        options.addArguments(driverConfig.browserCheck);
        options.addArguments(driverConfig.devShm);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }
}
