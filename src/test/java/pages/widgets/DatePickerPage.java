package pages.widgets;

import loggerUtility.LoggerUtility;
import objectData.model.DatePickerObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.locators.DatePickerLocators;

import java.util.List;

public class DatePickerPage extends WidgetsPage{

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithDate(DatePickerObject datePickerObject){
        elementMethods.clickLocator(DatePickerLocators.selectDateLocator);
        LoggerUtility.info("The user clicks on selectDateElement element");

        elementMethods.selectLocator(DatePickerLocators.selectDateMonthLocator, datePickerObject.getMonth());
        LoggerUtility.info("The user selects from selectDateMonthElement the value " + datePickerObject.getMonth());

        elementMethods.selectLocator(DatePickerLocators.selectDateYearLocator, datePickerObject.getYear());
        LoggerUtility.info("The user selects from selectDateYearElement the value " + datePickerObject.getYear());

        List<WebElement> monthDaysList = elementMethods.getAllElements(DatePickerLocators.monthDaysListLocator, true);
        var desireDay = monthDaysList.stream()
                .filter(element -> element.getText().equalsIgnoreCase(datePickerObject.getDay()))
                .findFirst()
                .orElseThrow();
        elementMethods.clickElementJS(desireDay);
        LoggerUtility.info("The user selects from days displayed the value " + datePickerObject.getDay());
    }

    public void interactWithDateTime(DatePickerObject datePickerObject){
        elementMethods.clickLocator(DatePickerLocators.selectDateTimeLocator);
        LoggerUtility.info("The user clicks on selectDateTimeElement element");

        elementMethods.clickLocator(DatePickerLocators.selectDateTimeSelectedMonthLocator);
        LoggerUtility.info("The user clicks on selectDateTimeSelectedMonthElement element");

        elementMethods.clickElementJS(getDesireElement(DatePickerLocators.selectDateTimeMonthListLocator, datePickerObject.getMonth()));
        LoggerUtility.info("The user selects from selectDateTimeSelectedMonthElement the value " + datePickerObject.getMonth());

        elementMethods.clickElementJS(getDesireElement(DatePickerLocators.timeOptionsListLocator, datePickerObject.getTime()));
        LoggerUtility.info("The user selects from timeOptionsList the value " + datePickerObject.getTime());
    }

    private WebElement getDesireElement(By locator, String value){
        List<WebElement> elements = elementMethods.getAllElements(locator, true);
        return elements.stream()
                .filter(element -> element.getText().contains(value))
                .findFirst()
                .orElseThrow();
    }
}
