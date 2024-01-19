package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.widgets.ProgressPage;
import pages.widgets.ToolTipsPage;
import pages.widgets.WidgetsPage;
import sharedData.Hooks;

public class ToolTipsTest extends Hooks {

    @Test
    public void toolTipsMethod() {
        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_WIDGETS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_WIDGETS + " menu");

        WidgetsPage widgetsPage = new WidgetsPage(getDriver());
        widgetsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_TOOLTIPS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_TOOLTIPS + " subMenu");

        ToolTipsPage toolTipsPage = new ToolTipsPage(getDriver());
        toolTipsPage.hoverButtonFieldProcess();
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I hover on both button and field elements to interact with the messages");
    }
}
