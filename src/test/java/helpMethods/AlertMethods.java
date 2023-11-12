package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class AlertMethods {

    private WebDriver driver;

    public void alertWithOk(){
        waitAlertIsDisplayed();
        driver.switchTo().alert().accept();
    }

    public void alertWithCancel(){
        waitAlertIsDisplayed();
        driver.switchTo().alert().dismiss();
    }

    public void alertWithText(String text){
        waitAlertIsDisplayed();
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public void waitAlertIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
    }
}
