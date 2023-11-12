package tests;

import objectData.WebTableObject;
import org.testng.annotations.Test;
import pages.MenuPageType;
import pages.elements.ElementsPage;
import pages.HomePage;
import pages.elements.WebTablePage;
import sharedData.Hooks;

public class WebTableTest extends Hooks {

    @Test
    public void webTableMethod(){

        WebTableObject webTableObject = new WebTableObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_ELEMENTS);

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_WEBTABLE);

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addEntryIntoTable(webTableObject);
        webTablePage.modifyNewEntry(webTableObject);
        webTablePage.deleteNewEntry(webTableObject);
    }
}
