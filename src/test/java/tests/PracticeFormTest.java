package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.PracticeFormObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.forms.FormsPage;
import pages.forms.PracticeFormPage;
import sharedData.Hooks;

public class PracticeFormTest extends Hooks {

    @Test
    public void practiceFormMethod() {
        PracticeFormObject practiceFormObject = new PracticeFormObject(testData);

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
