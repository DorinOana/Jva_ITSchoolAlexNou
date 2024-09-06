package pages.widgets;

import loggerUtility.LoggerUtility;
import objectData.model.ProgressObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressPage extends WidgetsPage{

    public ProgressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "progressBar")
    private WebElement progressBarElement;
    @FindBy(xpath = "//div[@role='progressbar']")
    private WebElement progressBarValueElement;
    @FindBy(xpath = "//div[@id='progressBarContainer']/button")
    private WebElement startStopButtonElement;

    public ProgressPage interactWithProgress(ProgressObject progressObject){
        var currentValue = progressBarValueElement.getText();
        elementMethods.clickElement(startStopButtonElement);
        LoggerUtility.info("The user clicks on startStopButtonElement element");

        while (!currentValue.contains(progressObject.getProgressValue())){
            currentValue = progressBarValueElement.getText();
            if (currentValue.contains(progressObject.getProgressValue())){
                elementMethods.clickElement(startStopButtonElement);
            }
        }
        LoggerUtility.info("The user stops the progress bar at value " + progressObject.getProgressValue());
        return this;
    }
}
