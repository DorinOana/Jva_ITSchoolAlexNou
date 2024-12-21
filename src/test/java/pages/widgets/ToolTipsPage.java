package pages.widgets;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.locators.ToolTipsLocators;

public class ToolTipsPage extends WidgetsPage{

    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    public void hoverButtonFieldProcess(){
        elementMethods.waitForSeconds(2500);
        elementMethods.hoverLocator(ToolTipsLocators.hoverMeButtonLocator);
        LoggerUtility.info("The user moves the mouse on on hoverMeButtonElement element");

        elementMethods.visibilityOfLocator(ToolTipsLocators.hoverMeButtonTextLocator);
        LoggerUtility.info("The user validates the presence of hoverMeButtonTextElement field");

        elementMethods.hoverLocator(ToolTipsLocators.hoverMeFieldLocator);
        LoggerUtility.info("The user moves the mouse on on hoverMeFieldElement element");

        elementMethods.visibilityOfLocator(ToolTipsLocators.hoverMeFieldTextLocator);
        LoggerUtility.info("The user validates the presence of hoverMeFieldTextElement field");
    }
}
