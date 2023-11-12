package sharedData.browser.service;

import logger.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import xmlFile.xmlNode.DriverConfig;

import java.time.Duration;

@Getter
public class EdgeBrowserService implements BrowserService{

    private WebDriver driver;

    @Override
    public void openBrowser(DriverConfig driverConfig) {
        EdgeOptions options = (EdgeOptions) getBrowserOptions(driverConfig);
        driver = new EdgeDriver(options);
        driver.get(driverConfig.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }
}
