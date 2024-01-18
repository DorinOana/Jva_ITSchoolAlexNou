package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.AutoCompleteObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.widgets.AccordionPage;
import pages.widgets.AutoCompletePage;
import pages.widgets.WidgetsPage;
import sharedData.Hooks;

public class AutoCompleteTest extends Hooks {

    @Test
    public void autoCompleteMethod() {
        AutoCompleteObject autoCompleteObject = new AutoCompleteObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_WIDGETS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_WIDGETS + " menu");

        WidgetsPage widgetsPage = new WidgetsPage(getDriver());
        widgetsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_AUTOCOMPLETE);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_AUTOCOMPLETE + " subMenu");

        AutoCompletePage autoCompletePage = new AutoCompletePage(getDriver());
        autoCompletePage.interactWithMultipleColors(autoCompleteObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I interact with multiple colors like " + autoCompleteObject.getMultipleColors());

        autoCompletePage.interactWithSingleColor(autoCompleteObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I interact with single color like " + autoCompleteObject.getSingleColor());
    }
}