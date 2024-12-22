package pageLocators.widgets;

import org.openqa.selenium.By;

public class ToolTipsLocators {
    public static final By hoverMeButtonLocator = By.id("toolTipButton");
    public static final By hoverMeButtonTextLocator = By.xpath("//*[text()='You hovered over the Button']");
    public static final By hoverMeFieldLocator = By.id("toolTipTextField");
    public static final By hoverMeFieldTextLocator = By.xpath("//*[text()='You hovered over the text field']");
}
