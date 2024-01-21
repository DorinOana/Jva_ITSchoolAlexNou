package sharedData.browser;

import org.openqa.selenium.WebDriver;
import sharedData.browser.service.local.ChromeBrowserService;
import sharedData.browser.service.local.EdgeBrowserService;
import sharedData.browser.service.remote.ChromeBrowserRemoteService;
import sharedData.browser.service.remote.EdgeBrowserRemoteService;
import xmlFile.GeneralXml;
import xmlFile.xmlNode.Configuration;

public class BrowserFactory {

    public WebDriver getBrowserDriver() {
        String ci_cd = System.getProperty("ci_cd");
        String browser = System.getProperty("browser");
        Configuration configuration = GeneralXml.CreateConfig(Configuration.class);

        if(Boolean.parseBoolean(ci_cd)) {
            configuration.driverConfig.setHeadless("--headless");
            switch (browser){
                case BrowserType.BROWSER_CHROME:
                    var chromeService = new ChromeBrowserRemoteService();
                    chromeService.openBrowser(configuration.driverConfig);
                    return chromeService.getDriver();
                case BrowserType.BROWSER_EDGE:
                    var edgeService = new EdgeBrowserRemoteService();
                    edgeService.openBrowser(configuration.driverConfig);
                    return edgeService.getDriver();
            }
        }
        else {
            browser = configuration.driverConfig.localBrowser;
            switch (browser){
                case BrowserType.BROWSER_CHROME:
                    var chromeService = new ChromeBrowserService();
                    chromeService.openBrowser(configuration.driverConfig);
                    return chromeService.getDriver();
                case BrowserType.BROWSER_EDGE:
                    var edgeService = new EdgeBrowserService();
                    edgeService.openBrowser(configuration.driverConfig);
                    return edgeService.getDriver();
            }
        }
        return null;
    }
}
