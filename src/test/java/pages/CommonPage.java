package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.locators.CommonLocators;

import java.util.List;

public class CommonPage extends BasePage{

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public void enterSpecificSubMenu(String subMenu){
        List<WebElement> subMenuOptionsList = elementMethods.getAllElements(CommonLocators.subMenuOptionsListLocator, true);
        for (WebElement webElement : subMenuOptionsList) {
            if (webElement.getText().equalsIgnoreCase(subMenu)) {
                elementMethods.scrollDownLocator(300);
                LoggerUtility.info("The user scrolls down the page for seeing subMenu: " + subMenu);
                elementMethods.clickElementJS(webElement);
                LoggerUtility.info("The user clicks on subMenu: " + subMenu);
                break;
            }
        }
    }
}
