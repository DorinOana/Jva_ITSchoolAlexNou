package pages.alertFrameWindow;

import loggerUtility.LoggerUtility;
import objectData.model.AlertObject;
import org.openqa.selenium.WebDriver;
import pageLocators.alertFrameWindow.AlertLocators;

public class AlertPage extends AlertFrameWindowPage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void dealAlertOkProcess() {
        elementMethods.clickLocatorJS(AlertLocators.alertOkLocator);
        LoggerUtility.info("The user clicks on alertOkElement");

        alertMethods.alertWithOk();
        LoggerUtility.info("The user interacts with alertOk");
    }

    public void dealAlertDelayProcess() {
        elementMethods.clickLocatorJS(AlertLocators.alertDelayLocator);
        LoggerUtility.info("The user clicks on alertDelayElement");

        alertMethods.alertWithOk();
        LoggerUtility.info("The user interacts with alertDelay");
    }

    public void dealAlertOkCancelProcess() {
        elementMethods.clickLocatorJS(AlertLocators.alertOkCancelLocator);
        LoggerUtility.info("The user clicks on alertOkCancelElement");

        alertMethods.alertWithCancel();
        LoggerUtility.info("The user interacts with alertOkCancel");
    }

    public void dealAlertValue(AlertObject alertObject) {
        elementMethods.clickLocatorJS(AlertLocators.alertValueLocator);
        LoggerUtility.info("The user clicks on alertValueElement");

        alertMethods.alertWithText(alertObject.getAlertValue());
        LoggerUtility.info("The user interacts with alertValue using " + alertObject.getAlertValue());
    }
}
