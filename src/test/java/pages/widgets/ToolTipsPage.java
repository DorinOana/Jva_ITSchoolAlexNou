package pages.widgets;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends WidgetsPage{

    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "toolTipButton")
    private WebElement hoverMeButtonElement;
    @FindBy(xpath = "//*[text()='You hovered over the Button']")
    private WebElement hoverMeButtonTextElement;
    @FindBy(id = "toolTipTextField")
    private WebElement hoverMeFieldElement;
    @FindBy(xpath = "//*[text()='You hovered over the text field']")
    private WebElement hoverMeFieldTextElement;

    public ToolTipsPage hoverButtonFieldProcess(){
        elementMethods.waitForSeconds(2500);
        elementMethods.hoverElement(hoverMeButtonElement);
        LoggerUtility.info("The user moves the mouse on on hoverMeButtonElement element");

        elementMethods.visibilityOfElement(hoverMeButtonTextElement);
        LoggerUtility.info("The user validates the presence of hoverMeButtonTextElement field");

        elementMethods.hoverElement(hoverMeFieldElement);
        LoggerUtility.info("The user moves the mouse on on hoverMeFieldElement element");

        elementMethods.visibilityOfElement(hoverMeFieldTextElement);
        LoggerUtility.info("The user validates the presence of hoverMeFieldTextElement field");        return this;
    }
}
