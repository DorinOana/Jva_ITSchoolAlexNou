package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
public class FrameMethods {

    private WebDriver driver;

    public void switchFrameById (String text){
        driver.switchTo().frame(text);
    }

    public void switchFrameByElement(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
