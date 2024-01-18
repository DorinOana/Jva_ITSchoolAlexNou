package pages.widgets;

import logger.LoggerUtility;
import objectData.AutoCompleteObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class AutoCompletePage extends WidgetsPage{
    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "autoCompleteMultipleInput")
    private WebElement multipleColorsElement;
    @FindBy(id = "autoCompleteSingleInput")
    private WebElement singleColorElement;
    @FindBy(css = ".css-12jo7m5.auto-complete__multi-value__label")
    private List<WebElement> selectedMultipleColorsList;
    @FindBy(css = ".auto-complete__single-value.css-1uccc91-singleValue")
    private WebElement selectedSingleColorElement;

    public AutoCompletePage interactWithMultipleColors(AutoCompleteObject autoCompleteObject){
        for (String color: autoCompleteObject.getMultipleColors()){
            elementMethods.fillElement(multipleColorsElement, color);
            LoggerUtility.info("The user fills multipleColorsElement with " + color + " value");
            elementMethods.fillElement(multipleColorsElement, Keys.ENTER);
            LoggerUtility.info("The user presses enter in order to select the color");
        }

        var actualList = selectedMultipleColorsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Assert.assertTrue(areListsEqual(autoCompleteObject.getMultipleColors(), actualList));
        LoggerUtility.info("The user validates the presence of all colors selected");
        return this;
    }

    public AutoCompletePage interactWithSingleColor(AutoCompleteObject autoCompleteObject){
        elementMethods.fillElement(singleColorElement, autoCompleteObject.getSingleColor());
        LoggerUtility.info("The user fills singleColorElement with " + autoCompleteObject.getSingleColor() + " value");
        elementMethods.fillElement(singleColorElement, Keys.ENTER);
        LoggerUtility.info("The user presses enter in order to select the color");

        elementMethods.visibilityOfElement(selectedSingleColorElement);
        Assert.assertEquals(autoCompleteObject.getSingleColor(), selectedSingleColorElement.getText());
        LoggerUtility.info("The user validates the presence of selected color");
        return this;
    }

    private boolean areListsEqual(List<String> list1, List<String> list2) {
        return list1 != null && list2 != null && list1.containsAll(list2) && list2.containsAll(list1);
    }
}
