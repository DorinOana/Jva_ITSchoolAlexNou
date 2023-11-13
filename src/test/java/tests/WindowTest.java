package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.alertFrameWindow.AlertFrameWindowPage;
import pages.alertFrameWindow.WindowPage;
import sharedData.Hooks;

public class WindowTest extends Hooks {

    @Test
    public void windowMethod(){
        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_ALERTSFRAMEWINDOW);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_ALERTSFRAMEWINDOW + " menu");

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_WINDOWS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_WINDOWS + " subMenu");

        WindowPage windowPage = new WindowPage(getDriver());
        windowPage.dealWithSingleTab();
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I deal with single tab process");
        windowPage.dealWithSingleWindow();
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I deal with single window process");
    }
}
