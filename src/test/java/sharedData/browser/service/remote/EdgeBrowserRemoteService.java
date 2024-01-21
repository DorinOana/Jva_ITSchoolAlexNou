package sharedData.browser.service.remote;

import logger.LoggerUtility;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import sharedData.browser.service.BrowserService;
import xmlFile.xmlNode.DriverConfig;

import java.net.URL;
import java.time.Duration;

@Getter
public class EdgeBrowserRemoteService implements BrowserService {

    private WebDriver driver;

    @SneakyThrows
    @Override
    public void openBrowser(DriverConfig driverConfig) {
        EdgeOptions options = (EdgeOptions) getBrowserOptions(driverConfig);
        driver = new RemoteWebDriver(new URL(driverConfig.remoteUrl), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(driverConfig.url);
        LoggerUtility.info("The driver is opened with success");
    }

    @Override
    public Object getBrowserOptions(DriverConfig driverConfig) {
        EdgeOptions options = new EdgeOptions();
        if (!driverConfig.headless.isEmpty()) {
            options.addArguments(driverConfig.headless);
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
