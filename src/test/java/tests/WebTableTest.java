package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.DataResource;
import objectData.model.WebTableObject;
import org.testng.annotations.Test;
import pages.MenuPageType;
import pages.elements.ElementsPage;
import pages.HomePage;
import pages.elements.WebTablePage;
import sharedData.Hooks;
import suites.TestSuite;

public class WebTableTest extends Hooks {

    @Test(groups = {TestSuite.REGRESSION_SUITE, TestSuite.ELEMENTS_SUITE})
    public void webTableMethod() {
        WebTableObject webTableObject = new WebTableObject(DataResource.TEST_WEB_TABLE);

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_ELEMENTS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_ELEMENTS + " menu");

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_WEBTABLE);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_WEBTABLE + " subMenu");

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addEntryIntoTable(webTableObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I add new entry into table with the following values: " + webTableObject);
        webTablePage.modifyNewEntry(webTableObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I modify the last entry added into table");
        webTablePage.deleteNewEntry(webTableObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I delete the last entry added into table");
    }
}
