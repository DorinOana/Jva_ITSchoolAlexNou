package pageLocators.elements;

import org.openqa.selenium.By;

public class WebTableLocator {
    public static final By addNewEntryLocator = By.id("addNewRecordButton");
    public static final By firstNameLocator = By.id("firstName");
    public static final By lastNameLocator = By.id("lastName");
    public static final By emailLocator = By.id("userEmail");
    public static final By ageLocator = By.id("age");
    public static final By salaryLocator = By.id("salary");
    public static final By departmentLocator = By.id("department");
    public static final By submitLocator = By.id("submit");
    public static final By tableRowsListLocator = By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr -odd' or @class='rt-tr -even']");
    public static final By tableEditButtonsListLocator = By.xpath("//span[@title='Edit']");
    public static final By tableDeleteButtonsListLocator = By.xpath("//span[@title='Delete']");
}
