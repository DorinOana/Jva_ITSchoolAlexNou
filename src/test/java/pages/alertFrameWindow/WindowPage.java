package pages.alertFrameWindow;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.locators.WindowLocator;

public class WindowPage extends AlertFrameWindowPage {

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    public void dealWithSingleTab() {
        elementMethods.clickLocator(WindowLocator.newTabLocator);
        LoggerUtility.info("The user clicks on newTabElement");

        tabMethods.switchToASpecificTabByIndex(1);
        LoggerUtility.info("The user switches on second tab");

        WebElement sampleMessageElement = driver.findElement(WindowLocator.sampleMessageLocator);
        System.out.println(sampleMessageElement.getText());
        LoggerUtility.info("The user interacts with sampleMessageElement");

        driver.close();
        LoggerUtility.info("The user closes the current tab focused");

        tabMethods.switchToASpecificTabByIndex(0);
        LoggerUtility.info("The user switches on first tab");
    }

    public void dealWithSingleWindow() {
        elementMethods.clickLocator(WindowLocator.newWindowLocator);
        LoggerUtility.info("The user clicks on newWindowElement");

        tabMethods.switchToASpecificTabByIndex(1);
        LoggerUtility.info("The user switches on second tab");

        WebElement sampleMessageElement = driver.findElement(WindowLocator.sampleMessageLocator);
        System.out.println(sampleMessageElement.getText());
        LoggerUtility.info("The user interacts with sampleMessageElement");

        driver.close();
        LoggerUtility.info("The user closes the current tab focused");

        tabMethods.switchToASpecificTabByIndex(0);
        LoggerUtility.info("The user switches on first tab");
    }
}
