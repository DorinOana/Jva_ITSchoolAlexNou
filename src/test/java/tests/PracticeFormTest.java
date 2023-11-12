package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.forms.FormsPage;
import sharedData.Hooks;

public class PracticeFormTest extends Hooks {

    @Test
    public void practiceFormMethod(){
        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_FORMS);

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_PRACTICEFORM);
    }
}
