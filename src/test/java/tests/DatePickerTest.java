package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.DataResource;
import objectData.model.DatePickerObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.widgets.DatePickerPage;
import pages.widgets.WidgetsPage;
import sharedData.Hooks;
import suites.TestSuite;

public class DatePickerTest extends Hooks {

    @Test(groups = {TestSuite.REGRESSION_SUITE, TestSuite.WIDGETS_SUITE})
    public void datePickerMethod() {
        DatePickerObject datePickerObject = new DatePickerObject(DataResource.TEST_DATE_PICKER);

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_WIDGETS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_WIDGETS + " menu");

        WidgetsPage widgetsPage = new WidgetsPage(getDriver());
        widgetsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_DATEPICKER);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_DATEPICKER + " subMenu");

        DatePickerPage datePickerPage = new DatePickerPage(getDriver());
        datePickerPage.interactWithDate(datePickerObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I interact with datepicker selecting the desire date");

        datePickerPage.interactWithDateTime(datePickerObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I interact with datepicker selecting the desire date and time");
    }
}