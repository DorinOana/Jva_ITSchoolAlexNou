package pages.locators;

import org.openqa.selenium.By;

public class PracticeFormLocators {
    public static final By firstNameLocator = By.id("firstName");
    public static final By lastNameLocator = By.id("lastName");
    public static final By emailLocator = By.id("userEmail");
    public static final By genderOptionsListLocator = By.xpath("//label[contains(@for,'gender')]");
    public static final By numberLocator = By.id("userNumber");
    public static final By subjectsLocator = By.id("subjectsInput");
    public static final By hobbiesOptionsListLocator = By.xpath("//label[contains(@for,'hobbies')]");
    public static final By addressLocator = By.id("currentAddress");
    public static final By stateLocator = By.xpath("//div[text()='Select State']");
    public static final By stateInputLocator = By.id("react-select-3-input");
    public static final By cityLocator = By.xpath("//div[text()='Select City']");
    public static final By cityInputLocator = By.id("react-select-4-input");
    public static final By submitLocator = By.id("submit");
    public static final By thankYouTableListLocator = By.cssSelector(".table tr");
    public static final By closeLocator = By.id("closeLargeModal");
    public static final By dateDropDownDaysListLocator = By.xpath("//div[@class='react-datepicker__month']//div[not(contains(@class, 'day--outside-month')) and @role='option']");
    public static final By dateOfBirthLocator = By.id("dateOfBirthInput");
    public static final By dateOfBirthMonthLocator = By.cssSelector(".react-datepicker__month-select");
    public static final By dateOfBirthYearLocator = By.cssSelector(".react-datepicker__year-select");
}
