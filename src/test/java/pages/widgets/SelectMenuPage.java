package pages.widgets;

import logger.LoggerUtility;
import objectData.model.SelectMenuObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectMenuPage extends WidgetsPage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Select Option']")
    private WebElement selectOptionElement;
    @FindBy(xpath = "//div[text()='Select Title']")
    private WebElement selectOneElement;
    @FindBy(id = "oldSelectMenu")
    private WebElement oldSelectElement;
    @FindBy(xpath = "//b[text()='Multiselect drop down']/../..//div[@class=' css-1wy0on6']")
    private WebElement multiSelectElement;

    public SelectMenuPage interactWithSelectValue(SelectMenuObject selectMenuObject) {
        elementMethods.clickElement(selectOptionElement);
        LoggerUtility.info("The user clicks on selectOptionElement element");
        By optionLocator = By.xpath("//*[text()='" + selectMenuObject.getSelectValue() + "']");
        elementMethods.clickElement(driver.findElement(optionLocator));
        LoggerUtility.info("The user clicks on " + selectMenuObject.getSelectValue() + " option");
        return this;
    }

    public SelectMenuPage interactWithSelectOne(SelectMenuObject selectMenuObject) {
        elementMethods.clickElement(selectOneElement);
        LoggerUtility.info("The user clicks on selectOneElement element");
        By optionLocator = By.xpath("//*[text()='" + selectMenuObject.getSelectOne() + "']");
        elementMethods.clickElement(driver.findElement(optionLocator));
        LoggerUtility.info("The user clicks on " + selectMenuObject.getSelectOne() + " option");
        return this;
    }

    public SelectMenuPage interactWithOldSelect(SelectMenuObject selectMenuObject) {
        elementMethods.selectElement(oldSelectElement, selectMenuObject.getOldStyleMenu());
        LoggerUtility.info("The user selects from oldSelectElement the value " + selectMenuObject.getOldStyleMenu());
        return this;
    }

    public SelectMenuPage interactWithMultiSelect(SelectMenuObject selectMenuObject) {
        elementMethods.scrollDownElement(400);
        elementMethods.clickElement(multiSelectElement);
        LoggerUtility.info("The user clicks on multiSelectElement element");
        for (String color : selectMenuObject.getMultiSelect()) {
            By optionLocator = By.xpath("//div[@class=' css-26l3qy-menu']//*[text()='" + color + "']");
            elementMethods.clickElement(driver.findElement(optionLocator));
            LoggerUtility.info("The user clicks on " + color + " option");
        }
        return this;
    }
}
