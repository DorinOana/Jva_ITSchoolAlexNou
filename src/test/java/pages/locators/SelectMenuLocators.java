package pages.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class SelectMenuLocators {
    public static final By selectOptionLocator = By.xpath("//div[text()='Select Option']");
    public static final By selectOneLocator = By.xpath("//div[text()='Select Title']");
    public static final By oldSelectLocator = By.id("oldSelectMenu");
    public static final By multiSelectLocator = By.xpath("//b[text()='Multiselect drop down']/../..//div[@class=' css-1wy0on6']");
}
