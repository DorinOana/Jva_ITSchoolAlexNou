package pages.alertFrameWindow;

import logger.LoggerUtility;
import objectData.AlertObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends AlertFrameWindowPage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertOkElement;
    @FindBy(id = "timerAlertButton")
    private WebElement alertDelayElement;
    @FindBy(id = "confirmButton")
    private WebElement alertOkCancelElement;
    @FindBy(id = "promtButton")
    private WebElement alertValueElement;

    public void dealAlertOkProcess() {
        elementMethods.clickElement(alertOkElement);
        LoggerUtility.info("The user clicks on alertOkElement");

        alertMethods.alertWithOk();
        LoggerUtility.info("The user interacts with alertOk");
    }

    public void dealAlertDelayProcess() {
        elementMethods.clickElement(alertDelayElement);
        LoggerUtility.info("The user clicks on alertDelayElement");

        alertMethods.alertWithOk();
        LoggerUtility.info("The user interacts with alertDelay");
    }

    public void dealAlertOkCancelProcess() {
        elementMethods.clickElement(alertOkCancelElement);
        LoggerUtility.info("The user clicks on alertOkCancelElement");

        alertMethods.alertWithCancel();
        LoggerUtility.info("The user interacts with alertOkCancel");
    }

    public void dealAlertValue(AlertObject alertObject) {
        elementMethods.clickElementJS(alertValueElement);
        LoggerUtility.info("The user clicks on alertValueElement");

        alertMethods.alertWithText(alertObject.getAlertValue());
        LoggerUtility.info("The user interacts with alertValue using " + alertObject.getAlertValue());
    }
}
