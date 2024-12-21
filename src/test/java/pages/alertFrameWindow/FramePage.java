package pages.alertFrameWindow;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.locators.FrameLocators;

public class FramePage extends AlertFrameWindowPage{

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public void dealWithIFrameProcess(){
        frameMethods.switchFrameByElement(FrameLocators.firstIFrameLocator);
        LoggerUtility.info("The user switches on firstIFrameElement iframe");

        WebElement sampleHeadingElement = driver.findElement(FrameLocators.sampleHeadingLocator);
        System.out.println(sampleHeadingElement.getText());
        LoggerUtility.info("The user interacts with sampleHeadingElement");

        frameMethods.switchToDefault();
        LoggerUtility.info("The user switches on default frame");

        frameMethods.switchFrameByElement(FrameLocators.secondIFrameLocator);
        LoggerUtility.info("The user switches on secondIFrameElement iframe");

        sampleHeadingElement = driver.findElement(FrameLocators.sampleHeadingLocator);
        System.out.println(sampleHeadingElement.getText());
        LoggerUtility.info("The user interacts with sampleHeadingElement");

        frameMethods.switchToDefault();
        LoggerUtility.info("The user switches on default frame");
    }
}
