package pages;

import helpMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected ElementMethods elementMethods;
    protected FrameMethods frameMethods;
    protected AlertMethods alertMethods;
    protected TabMethods tabMethods;
    protected PageMethods pageMethods;

    public BasePage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        frameMethods = new FrameMethods(driver);
        alertMethods = new AlertMethods(driver);
        tabMethods = new TabMethods(driver);
        pageMethods = new PageMethods(driver);
    }
}
