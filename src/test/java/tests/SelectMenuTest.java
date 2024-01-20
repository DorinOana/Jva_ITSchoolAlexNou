package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.AlertObject;
import objectData.SelectMenuObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.widgets.SelectMenuPage;
import pages.widgets.ToolTipsPage;
import pages.widgets.WidgetsPage;
import sharedData.Hooks;

public class SelectMenuTest extends Hooks {

    @Test
    public void selectMenuMethod() {
        SelectMenuObject selectMenuObject = new SelectMenuObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_WIDGETS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_WIDGETS + " menu");

        WidgetsPage widgetsPage = new WidgetsPage(getDriver());
        widgetsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_SELECTMENU);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_SELECTMENU + " subMenu");

        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());
        selectMenuPage.interactWithSelectValue(selectMenuObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I choose the desire option from select value element");

        selectMenuPage.interactWithSelectOne(selectMenuObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I choose the desire option from select one element");

        selectMenuPage.interactWithOldSelect(selectMenuObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I choose the desire option from old select element");

        selectMenuPage.interactWithMultiSelect(selectMenuObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I choose the desire options from multiselect element");

    }
}
