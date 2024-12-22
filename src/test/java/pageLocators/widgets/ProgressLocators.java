package pageLocators.widgets;

import org.openqa.selenium.By;

public class ProgressLocators {
    public static final By progressBarLocator = By.id("progressBar");
    public static final By progressBarValueLocator = By.xpath("//div[@role='progressbar']");
    public static final By startStopButtonLocator = By.xpath("//div[@id='progressBarContainer']/button");
}
