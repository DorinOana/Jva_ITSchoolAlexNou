package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.DataResource;
import objectData.model.ProgressObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.widgets.ProgressPage;
import pages.widgets.WidgetsPage;
import sharedData.Hooks;

public class ProgressTest extends Hooks {

    @Test
    public void progressMethod() {
        ProgressObject progressObject = new ProgressObject(DataResource.TEST_PROGRESS_BAR);

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_WIDGETS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_WIDGETS + " menu");

        WidgetsPage widgetsPage = new WidgetsPage(getDriver());
        widgetsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_PROGRESS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_PROGRESS + " subMenu");

        ProgressPage progressPage = new ProgressPage(getDriver());
        progressPage.interactWithProgress(progressObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I interact with the progress to be moved to desire value");
    }
}
