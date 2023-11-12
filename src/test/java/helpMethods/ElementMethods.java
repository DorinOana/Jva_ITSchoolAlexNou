package helpMethods;

import objectData.WebTableObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void visibilityOfElementLocatedBy(By identificator) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(identificator));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(identificator));
    }

    public void waitForce(long value) {
        try {
            Thread.sleep(value);
        } catch (InterruptedException ignored) {
        }
    }

    public void visibilityOfElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void visibilityOfElements(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void presenceOfElements(By locator) {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void validateElementMessage(WebElement element, String expected) {
        visibilityOfElement(element);
        Assert.assertEquals(element.getText(), expected);
    }

    public void clickElement(WebElement webElement) {
        visibilityOfElement(webElement);
        webElement.click();
    }

    public void clickElementJS(WebElement element) {
        visibilityOfElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickElement(By locator) {
        visibilityOfElement(driver.findElement(locator));
        driver.findElement(locator).click();
    }

    public void fillElement(WebElement element, String value) {
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

    public void selectElementByText(WebElement element, String value) {
        visibilityOfElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void selectElementByValue(WebElement element, String value) {
        visibilityOfElement(element);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void hoverElement(By selector) {
        visibilityOfElementLocatedBy(selector);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(selector)).build().perform();
    }

    public void hoverElement(WebElement element) {
        visibilityOfElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
