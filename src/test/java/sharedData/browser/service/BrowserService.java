package sharedData.browser.service;

import configUtility.xmlNode.DriverConfig;

public interface BrowserService {

    void openBrowser(DriverConfig driverConfig);
    Object getBrowserOptions(DriverConfig driverConfig);
}
