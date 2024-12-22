package pages.widgets;

import loggerUtility.LoggerUtility;
import objectData.model.ProgressObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.widgets.ProgressLocators;

public class ProgressPage extends WidgetsPage{

    public ProgressPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithProgress(ProgressObject progressObject){
        WebElement progressBarValueElement = driver.findElement(ProgressLocators.progressBarValueLocator);
        var currentValue = progressBarValueElement.getText();

        elementMethods.clickLocatorJS(ProgressLocators.startStopButtonLocator);
        LoggerUtility.info("The user clicks on startStopButtonElement element");

        while (!currentValue.contains(progressObject.getProgressValue())){
            currentValue = progressBarValueElement.getText();
            if (currentValue.contains(progressObject.getProgressValue())){
                elementMethods.clickLocatorJS(ProgressLocators.startStopButtonLocator);
            }
        }
        LoggerUtility.info("The user stops the progress bar at value " + progressObject.getProgressValue());
    }
}
