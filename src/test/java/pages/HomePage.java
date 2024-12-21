package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.locators.HomeLocators;

import java.util.List;

public class HomePage extends CommonPage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterSpecificMenu(String menu){
        List<WebElement> menuOptionsList = elementMethods.getAllElements(HomeLocators.menuOptionsListLocator, true);
        for (WebElement webElement : menuOptionsList) {
            if (webElement.getText().equalsIgnoreCase(menu)) {
                elementMethods.scrollDownLocator(300);
                LoggerUtility.info("The user scrolls down the page for seeing menu: " + menu);
                elementMethods.clickElementJS(webElement);
                LoggerUtility.info("The user scrolls down the page for seeing menu: " + menu);
                break;
            }
        }
    }
}
