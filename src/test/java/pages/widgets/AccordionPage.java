package pages.widgets;

import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccordionPage extends WidgetsPage{

    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".accordion .card-header")
    private List<WebElement> accordionHeaderList;
    @FindBy(css = ".accordion .card-body")
    private List<WebElement> accordionBodyList;

    public AccordionPage interactWithAccordion(){
        for (int index = 0; index<accordionHeaderList.size(); index++){
            elementMethods.clickElementJS(accordionHeaderList.get(index));
            LoggerUtility.info("The user clicks on " + index + " header option from accordion");
            System.out.println(accordionBodyList.get(index).getText());
            LoggerUtility.info("The user prints the text from " + index + " header option");
        }
        return this;
    }
}
