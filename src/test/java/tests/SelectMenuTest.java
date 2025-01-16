package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.DataResource;
import objectData.model.SelectMenuObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.widgets.SelectMenuPage;
import pages.widgets.WidgetsPage;
import sharedData.Hooks;
import suites.TestSuite;

public class SelectMenuTest extends Hooks {

    @Test(groups = {TestSuite.REGRESSION_SUITE, TestSuite.WIDGETS_SUITE})
    public void selectMenuMethod() {
        SelectMenuObject selectMenuObject = new SelectMenuObject(DataResource.TEST_SELECT_MENU);

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
