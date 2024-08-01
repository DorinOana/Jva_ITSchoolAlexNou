package pages.widgets;

import logger.LoggerUtility;
import objectData.model.SliderObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends WidgetsPage{

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sliderValue")
    private WebElement sliderValueElement;
    @FindBy(xpath = "//input[@type='range']")
    private WebElement sliderElement;

    public SliderPage interactWithSlider(SliderObject sliderObject){
        var currentValue = sliderValueElement.getAttribute("value");
        while (!currentValue.equals(sliderObject.getSliderValue())){
            elementMethods.fillElement(sliderElement, Keys.ARROW_RIGHT);
            currentValue = sliderValueElement.getAttribute("value");
        }
        LoggerUtility.info("The user moves the slider to value: " + sliderObject.getSliderValue());
        return this;
    }
}
