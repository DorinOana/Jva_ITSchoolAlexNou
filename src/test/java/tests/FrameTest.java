package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.alertFrameWindow.AlertFrameWindowPage;
import pages.alertFrameWindow.FramePage;
import sharedData.Hooks;

public class FrameTest extends Hooks {

    @Test
    public void frameMethod(){
        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_ALERTSFRAMEWINDOW);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_ALERTSFRAMEWINDOW + " menu");

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_FRAMES);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_FRAMES + " subMenu");

        FramePage framePage = new FramePage(getDriver());
        framePage.dealWithIFrameProcess();
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I deal with iframe process");
    }
}
