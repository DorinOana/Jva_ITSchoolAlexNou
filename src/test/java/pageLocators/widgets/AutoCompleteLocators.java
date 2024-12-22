package pageLocators.widgets;

import org.openqa.selenium.By;

public class AutoCompleteLocators {
    public static final By multipleColorsLocator = By.id("autoCompleteMultipleInput");
    public static final By singleColorLocator = By.id("autoCompleteSingleInput");
    public static final By selectedMultipleColorsListLocator = By.cssSelector(".css-12jo7m5.auto-complete__multi-value__label");
    public static final By selectedSingleColorLocator = By.cssSelector(".auto-complete__single-value.css-1uccc91-singleValue");
}
