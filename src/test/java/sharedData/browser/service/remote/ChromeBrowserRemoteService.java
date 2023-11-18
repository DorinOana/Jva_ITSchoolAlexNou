package sharedData.browser.service.remote;

import logger.LoggerUtility;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import sharedData.browser.service.BrowserService;
import xmlFile.xmlNode.DriverConfig;

import java.net.URL;
import java.time.Duration;

@Getter
public class ChromeBrowserRemoteService implements BrowserService {

    private WebDriver driver;

    @SneakyThrows
    @Override
    public void openBrowser(DriverConfig driverConfig) {
        ChromeOptions options = (ChromeOptions) getBrowserOptions(driverConfig);
        driver = new RemoteWebDriver(new URL(driverConfig.remoteUrl), options);
        driver.get(driverConfig.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoggerUtility.info("The driver is opened with success");
    }

    @Override
    public Object getBrowserOptions(DriverConfig driverConfig) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(driverConfig.headless);
        options.addArguments(driverConfig.gpu);
        options.addArguments(driverConfig.resolution);
        options.addArguments(driverConfig.sandbox);
        options.addArguments(driverConfig.infoBars);
        options.addArguments(driverConfig.extensions);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }
}
