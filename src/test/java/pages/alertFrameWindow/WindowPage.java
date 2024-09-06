package pages.alertFrameWindow;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowPage extends AlertFrameWindowPage {

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabElement;
    @FindBy(id = "windowButton")
    private WebElement newWindowElement;
    @FindBy(id = "sampleHeading")
    private WebElement sampleMessageElement;

    public void dealWithSingleTab() {
        elementMethods.clickElement(newTabElement);
        LoggerUtility.info("The user clicks on newTabElement");

        tabMethods.switchToASpecificTabByIndex(1);
        LoggerUtility.info("The user switches on second tab");

        System.out.println(sampleMessageElement.getText());
        LoggerUtility.info("The user interacts with sampleMessageElement");

        driver.close();
        LoggerUtility.info("The user closes the current tab focused");

        tabMethods.switchToASpecificTabByIndex(0);
        LoggerUtility.info("The user switches on first tab");
    }

    public void dealWithSingleWindow() {
        elementMethods.clickElement(newWindowElement);
        LoggerUtility.info("The user clicks on newWindowElement");

        tabMethods.switchToASpecificTabByIndex(1);
        LoggerUtility.info("The user switches on second tab");

        System.out.println(sampleMessageElement.getText());
        LoggerUtility.info("The user interacts with sampleMessageElement");

        driver.close();
        LoggerUtility.info("The user closes the current tab focused");

        tabMethods.switchToASpecificTabByIndex(0);
        LoggerUtility.info("The user switches on first tab");
    }
}
