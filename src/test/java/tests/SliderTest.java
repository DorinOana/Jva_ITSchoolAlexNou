package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import objectData.DataResource;
import objectData.model.SliderObject;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPageType;
import pages.widgets.SliderPage;
import pages.widgets.WidgetsPage;
import sharedData.Hooks;

public class SliderTest extends Hooks {

    @Test
    public void sliderMethod() {
        SliderObject sliderObject = new SliderObject(DataResource.TEST_SLIDER);

        HomePage homePage = new HomePage(getDriver());
        homePage.enterSpecificMenu(MenuPageType.MENU_WIDGETS);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.MENU_WIDGETS + " menu");

        WidgetsPage widgetsPage = new WidgetsPage(getDriver());
        widgetsPage.enterSpecificSubMenu(MenuPageType.SUB_MENU_SLIDER);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I enter on " + MenuPageType.SUB_MENU_SLIDER + " subMenu");

        SliderPage sliderPage = new SliderPage(getDriver());
        sliderPage.interactWithSlider(sliderObject);
        ExtentUtility.attachTestLog(ReportStep.PASS_STEP, "I interact with the slider to be moved to desire value");
    }
}
