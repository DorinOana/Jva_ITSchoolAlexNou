package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods extends BaseMethods{

    public FrameMethods(WebDriver driver) {
        super(driver);
    }

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
