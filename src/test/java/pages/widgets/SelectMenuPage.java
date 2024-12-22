package pages.widgets;

import loggerUtility.LoggerUtility;
import objectData.model.SelectMenuObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageLocators.widgets.SelectMenuLocators;

public class SelectMenuPage extends WidgetsPage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithSelectValue(SelectMenuObject selectMenuObject) {
        elementMethods.clickLocator(SelectMenuLocators.selectOptionLocator);
        LoggerUtility.info("The user clicks on selectOptionElement element");
        By optionLocator = By.xpath("//*[text()='" + selectMenuObject.getSelectValue() + "']");
        elementMethods.clickElementJS(driver.findElement(optionLocator));
        LoggerUtility.info("The user clicks on " + selectMenuObject.getSelectValue() + " option");
    }

    public void interactWithSelectOne(SelectMenuObject selectMenuObject) {
        elementMethods.clickLocator(SelectMenuLocators.selectOneLocator);
        LoggerUtility.info("The user clicks on selectOneElement element");
        By optionLocator = By.xpath("//*[text()='" + selectMenuObject.getSelectOne() + "']");
        elementMethods.clickElementJS(driver.findElement(optionLocator));
        LoggerUtility.info("The user clicks on " + selectMenuObject.getSelectOne() + " option");
    }

    public void interactWithOldSelect(SelectMenuObject selectMenuObject) {
        elementMethods.selectLocator(SelectMenuLocators.oldSelectLocator, selectMenuObject.getOldStyleMenu());
        LoggerUtility.info("The user selects from oldSelectElement the value " + selectMenuObject.getOldStyleMenu());
    }

    public void interactWithMultiSelect(SelectMenuObject selectMenuObject) {
        elementMethods.scrollDownLocator(400);
        elementMethods.clickLocator(SelectMenuLocators.multiSelectLocator);
        LoggerUtility.info("The user clicks on multiSelectElement element");
        for (String color : selectMenuObject.getMultiSelect()) {
            By optionLocator = By.xpath("//div[@class=' css-26l3qy-menu']//*[text()='" + color + "']");
            elementMethods.clickElementJS(driver.findElement(optionLocator));
            LoggerUtility.info("The user clicks on " + color + " option");
        }
    }
}
