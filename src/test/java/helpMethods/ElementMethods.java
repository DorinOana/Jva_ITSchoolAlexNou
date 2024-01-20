package helpMethods;

import objectData.WebTableObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ElementMethods {

    private final WebDriver driver;
    private final WebDriverWait webDriverWait;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void visibilityOfElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void visibilityOfElements(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void clickElement(WebElement webElement) {
        visibilityOfElement(webElement);
        webElement.click();
    }

    public void hoverElement(WebElement webElement) {
        visibilityOfElement(webElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    public void clickElementJS(WebElement element) {
        visibilityOfElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void fillElement(WebElement element, String value) {
        visibilityOfElement(element);
        element.sendKeys(value);
    }

    public void fillElement(WebElement element, Keys value) {
        visibilityOfElement(element);
        element.sendKeys(value);
    }

    public void scrollDownElement(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")", "");
    }

    public void clearFillElement(WebElement element, String value){
        visibilityOfElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void selectElement(WebElement element, String value){
        visibilityOfElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
}
