package sharedData.browser.service;

import xmlFile.xmlNode.DriverConfig;

public interface BrowserService {

    void openBrowser(DriverConfig driverConfig);
    Object getBrowserOptions(DriverConfig driverConfig);
}
