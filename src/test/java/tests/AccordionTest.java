package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.widgets.AccordionPage;
import pages.widgets.WidgetsPage;
import sharedData.Hooks;
import suites.TestSuite;

public class AccordionTest extends Hooks {

    @Test(groups = {TestSuite.REGRESSION_SUITE, TestSuite.WIDGETS_SUITE})
    public void accordionMethod() {
        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_WIDGETS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_WIDGETS + " menu");

        WidgetsPage widgetsPage = new WidgetsPage(getDriver());
        widgetsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_ACCORDIAN);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_ACCORDIAN + " subMenu");

        AccordionPage accordionPage = new AccordionPage(getDriver());
        accordionPage.interactWithAccordion();
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I interact with all options from accordion");
    }
}