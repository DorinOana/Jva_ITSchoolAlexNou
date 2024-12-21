package helpMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods extends BaseMethods{

    public FrameMethods(WebDriver driver) {
        super(driver);
    }

    public void switchFrameByElement(By locator){
        driver.switchTo().frame(driver.findElement(locator));
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
