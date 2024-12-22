package pageLocators.widgets;

import org.openqa.selenium.By;

public class DatePickerLocators {
    public static final By selectDateLocator = By.id("datePickerMonthYearInput");
    public static final By selectDateMonthLocator = By.cssSelector(".react-datepicker__month-select");
    public static final By selectDateYearLocator = By.cssSelector(".react-datepicker__year-select");
    public static final By monthDaysListLocator = By.xpath("//div[@class='react-datepicker__month']/div/div[not(contains(@class, 'day--weekend')) and not(contains(@class, '--outside-month'))]");
    public static final By selectDateTimeLocator = By.id("dateAndTimePickerInput");
    public static final By selectDateTimeSelectedMonthLocator = By.cssSelector(".react-datepicker__month-read-view--selected-month");
    public static final By selectDateTimeMonthListLocator = By.cssSelector(".react-datepicker__month-dropdown>div");
    public static final By timeOptionsListLocator = By.cssSelector(".react-datepicker__time-list>li");
}
