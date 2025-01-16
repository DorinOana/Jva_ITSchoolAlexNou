package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.DataResource;
import objectData.model.AlertObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.alertFrameWindow.AlertFrameWindowPage;
import pages.alertFrameWindow.AlertPage;
import sharedData.Hooks;
import suites.TestSuite;

public class AlertTest extends Hooks {

    @Test(groups = {TestSuite.REGRESSION_SUITE, TestSuite.ALERTS_FRAME_WINDOWS_SUITE})
    public void alertMethod() {
        AlertObject alertObject = new AlertObject(DataResource.TEST_ALERT);

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_ALERTSFRAMEWINDOW);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_ALERTSFRAMEWINDOW + " menu");

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_ALERTS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_ALERTS + " subMenu");

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.dealAlertOkProcess();
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I deal with alert type with ok");
        alertPage.dealAlertDelayProcess();
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I deal with alert type with delay");
        alertPage.dealAlertOkCancelProcess();
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I deal with alert type with ok and cancel");
        alertPage.dealAlertValue(alertObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I deal with alert type with value using " + alertObject);
    }
}
