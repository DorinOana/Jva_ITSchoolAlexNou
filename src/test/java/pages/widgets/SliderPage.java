package pages.widgets;

import loggerUtility.LoggerUtility;
import objectData.model.SliderObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.locators.SliderLocators;

public class SliderPage extends WidgetsPage{

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithSlider(SliderObject sliderObject){
        WebElement sliderValueElement = driver.findElement(SliderLocators.sliderValueLocator);
        var currentValue = sliderValueElement.getDomAttribute("value");

        while (!currentValue.equals(sliderObject.getSliderValue())){
            elementMethods.fillLocator(SliderLocators.sliderLocator, Keys.ARROW_RIGHT);
            currentValue = sliderValueElement.getDomAttribute("value");
        }
        LoggerUtility.info("The user moves the slider to value: " + sliderObject.getSliderValue());
    }
}
