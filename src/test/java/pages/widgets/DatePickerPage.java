package pages.widgets;

import loggerUtility.LoggerUtility;
import objectData.model.DatePickerObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DatePickerPage extends WidgetsPage{

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "datePickerMonthYearInput")
    private WebElement selectDateElement;
    @FindBy(css = ".react-datepicker__month-select")
    private WebElement selectDateMonthElement;
    @FindBy(css = ".react-datepicker__year-select")
    private WebElement selectDateYearElement;
    @FindBy(xpath = "//div[@class='react-datepicker__month']/div/div[not(contains(@class, 'day--weekend')) and not(contains(@class, '--outside-month'))]")
    private List<WebElement> monthDaysList;
    @FindBy(id = "dateAndTimePickerInput")
    private WebElement selectDateTimeElement;
    @FindBy(css = ".react-datepicker__month-read-view--selected-month")
    private WebElement selectDateTimeSelectedMonthElement;
    @FindBy(css = ".react-datepicker__month-dropdown>div")
    private List<WebElement> selectDateTimeMonthList;
    @FindBy(css = ".react-datepicker__time-list>li")
    private List<WebElement> timeOptionsList;

    public DatePickerPage interactWithDate(DatePickerObject datePickerObject){
        elementMethods.clickElement(selectDateElement);
        LoggerUtility.info("The user clicks on selectDateElement element");

        elementMethods.selectElement(selectDateMonthElement, datePickerObject.getMonth());
        LoggerUtility.info("The user selects from selectDateMonthElement the value " + datePickerObject.getMonth());

        elementMethods.selectElement(selectDateYearElement, datePickerObject.getYear());
        LoggerUtility.info("The user selects from selectDateYearElement the value " + datePickerObject.getYear());

        elementMethods.visibilityOfElements(monthDaysList);
        var desireDay = monthDaysList.stream()
                .filter(element -> element.getText().equalsIgnoreCase(datePickerObject.getDay()))
                .findFirst()
                .orElseThrow();
        elementMethods.clickElementJS(desireDay);
        LoggerUtility.info("The user selects from days displayed the value " + datePickerObject.getDay());
        return this;
    }

    public DatePickerPage interactWithDateTime(DatePickerObject datePickerObject){
        elementMethods.clickElement(selectDateTimeElement);
        LoggerUtility.info("The user clicks on selectDateTimeElement element");

        elementMethods.clickElement(selectDateTimeSelectedMonthElement);
        LoggerUtility.info("The user clicks on selectDateTimeSelectedMonthElement element");

        elementMethods.clickElementJS(getDesireElement(selectDateTimeMonthList, datePickerObject.getMonth()));
        LoggerUtility.info("The user selects from selectDateTimeSelectedMonthElement the value " + datePickerObject.getMonth());

        elementMethods.clickElementJS(getDesireElement(timeOptionsList, datePickerObject.getTime()));
        LoggerUtility.info("The user selects from timeOptionsList the value " + datePickerObject.getTime());
        return this;
    }

    private WebElement getDesireElement(List<WebElement> elements, String value){
        return elements.stream()
                .filter(element -> element.getText().contains(value))
                .findFirst()
                .orElseThrow();
    }
}
