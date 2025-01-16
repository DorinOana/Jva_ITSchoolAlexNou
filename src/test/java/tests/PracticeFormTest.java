package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.DataResource;
import objectData.model.PracticeFormObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.forms.FormsPage;
import pages.forms.PracticeFormPage;
import sharedData.Hooks;
import suites.TestSuite;

public class PracticeFormTest extends Hooks {

    @Test(groups = {TestSuite.REGRESSION_SUITE, TestSuite.FORMS_SUITE})
    public void practiceFormMethod() {
        PracticeFormObject practiceFormObject = new PracticeFormObject(DataResource.TEST_PRACTICE_FORM);

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_FORMS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_FORMS + " menu");

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_PRACTICEFORM);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_PRACTICEFORM + " subMenu");

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(practiceFormObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I fill the entire form using the following values: " + practiceFormObject);
    }
}
