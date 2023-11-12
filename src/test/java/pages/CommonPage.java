package pages;

import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CommonPage extends BasePage{

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".show .btn-light>span")
    private List<WebElement> subMenuOptionsList;

    public void enterSpecificSubMenu(String subMenu){
        elementMethods.visibilityOfElements(subMenuOptionsList);
        for (int index = 0; index < subMenuOptionsList.size(); index++){
            if (subMenuOptionsList.get(index).getText().equalsIgnoreCase(subMenu)){
                elementMethods.scrollDownElement(300);
                LoggerUtility.info("The user scrolls down the page for seeing subMenu: "+subMenu);
                elementMethods.clickElement(subMenuOptionsList.get(index));
                LoggerUtility.info("The user clicks on subMenu: "+subMenu);
                break;
            }
        }
    }
}
