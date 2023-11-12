package pages;

import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']//h5")
    private List<WebElement> menuOptionsList;

    public void enterSpecificMenu(String menu){
        elementMethods.visibilityOfElements(menuOptionsList);
        for (int index = 0; index < menuOptionsList.size(); index++){
            if (menuOptionsList.get(index).getText().equalsIgnoreCase(menu)){
                elementMethods.scrollDownElement(300);
                LoggerUtility.info("The user scrolls down the page for seeing menu: "+menu);
                elementMethods.clickElement(menuOptionsList.get(index));
                LoggerUtility.info("The user scrolls down the page for seeing menu: "+menu);
                break;
            }
        }
    }
}
