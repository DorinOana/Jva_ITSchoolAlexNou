package tests;

import objectData.PracticeFormObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.forms.FormsPage;
import pages.forms.PracticeFormPage;
import sharedData.Hooks;

public class PracticeFormTest extends Hooks {

    @Test
    public void practiceFormMethod(){
        PracticeFormObject practiceFormObject = new PracticeFormObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_FORMS);

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_PRACTICEFORM);

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(practiceFormObject);
    }
}
