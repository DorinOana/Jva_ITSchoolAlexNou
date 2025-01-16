package pages.widgets;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.widgets.AccordionLocators;

import java.util.List;

public class AccordionPage extends WidgetsPage{

    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithAccordion(){
        List<WebElement> accordionHeaderList = elementMethods.getAllElements(AccordionLocators.accordionHeaderListLocator, true);
        for (int index = 0; index<accordionHeaderList.size(); index++){
            if (index>0) {
                elementMethods.clickElementJS(accordionHeaderList.get(index));
                LoggerUtility.info("The user clicks on " + index + " header option from accordion");
            }

            List<WebElement> accordionBodyList = elementMethods.getAllElements(AccordionLocators.accordionBodyListLocator, false);
            System.out.println(accordionBodyList.get(index).getText());
            LoggerUtility.info("The user prints the text from " + index + " header option");
        }
    }
}
