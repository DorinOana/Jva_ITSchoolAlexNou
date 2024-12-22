package pages.widgets;

import loggerUtility.LoggerUtility;
import objectData.model.AutoCompleteObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.widgets.AutoCompleteLocators;

import java.util.List;
import java.util.stream.Collectors;

public class AutoCompletePage extends WidgetsPage{
    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    public void interactWithMultipleColors(AutoCompleteObject autoCompleteObject){
        for (String color: autoCompleteObject.getMultipleColors()){
            elementMethods.fillLocator(AutoCompleteLocators.multipleColorsLocator, color);
            LoggerUtility.info("The user fills multipleColorsElement with " + color + " value");
            elementMethods.fillLocator(AutoCompleteLocators.multipleColorsLocator, Keys.ENTER);
            LoggerUtility.info("The user presses enter in order to select the color");
        }

        List<WebElement> selectedMultipleColorsList = elementMethods.getAllElements(AutoCompleteLocators.selectedMultipleColorsListLocator, true);
        var actualList = selectedMultipleColorsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Assert.assertTrue(areListsEqual(autoCompleteObject.getMultipleColors(), actualList));
        LoggerUtility.info("The user validates the presence of all colors selected");
    }

    public void interactWithSingleColor(AutoCompleteObject autoCompleteObject){
        elementMethods.fillLocator(AutoCompleteLocators.singleColorLocator, autoCompleteObject.getSingleColor());
        LoggerUtility.info("The user fills singleColorElement with " + autoCompleteObject.getSingleColor() + " value");
        elementMethods.fillLocator(AutoCompleteLocators.singleColorLocator, Keys.ENTER);
        LoggerUtility.info("The user presses enter in order to select the color");

        elementMethods.visibilityOfLocator(AutoCompleteLocators.selectedSingleColorLocator);
        WebElement selectedSingleColorElement = driver.findElement(AutoCompleteLocators.selectedSingleColorLocator);
        Assert.assertEquals(autoCompleteObject.getSingleColor(), selectedSingleColorElement.getText());
        LoggerUtility.info("The user validates the presence of selected color");
    }

    private boolean areListsEqual(List<String> list1, List<String> list2) {
        return list1 != null && list2 != null && list1.containsAll(list2) && list2.containsAll(list1);
    }
}
