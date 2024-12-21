package helpMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementMethods extends BaseMethods {

    private final WebDriverWait webDriverWait;

    public ElementMethods(WebDriver driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void visibilityOfLocator(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void visibilityOfElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> getAllElements(By locator, boolean waitForElements) {
        if (waitForElements) {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        }
        return driver.findElements(locator);
    }

    public void clickLocator(By locator) {
        visibilityOfLocator(locator);
        driver.findElement(locator).click();
    }

    public void clickElement(WebElement element) {
        visibilityOfElement(element);
        element.click();
    }

    public void hoverLocator(By locator) {
        visibilityOfLocator(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }

    public void clickLocatorJS(By locator) {
        visibilityOfLocator(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement((locator)));
    }

    public void clickElementJS(WebElement element) {
        visibilityOfElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void fillLocator(By locator, String value) {
        visibilityOfLocator(locator);
        driver.findElement(locator).sendKeys(value);
    }

    public void fillLocator(By locator, Keys value) {
        visibilityOfLocator(locator);
        driver.findElement(locator).sendKeys(value);
    }

    public void scrollDownLocator(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")", "");
    }

    public void clearFillLocator(By locator, String value){
        visibilityOfLocator(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void selectLocator(By locator, String value){
        visibilityOfLocator(locator);
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(value);
    }
}
