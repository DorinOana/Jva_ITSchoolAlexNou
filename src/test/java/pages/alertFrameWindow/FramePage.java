package pages.alertFrameWindow;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends AlertFrameWindowPage{

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement sampleHeadingElement;
    @FindBy(id = "frame1")
    private WebElement firstIFrameElement;
    @FindBy(id = "frame2")
    private WebElement secondIFrameElement;

    public void dealWithIFrameProcess(){
        frameMethods.switchFrameByElement(firstIFrameElement);
        LoggerUtility.info("The user switches on firstIFrameElement iframe");

        System.out.println(sampleHeadingElement.getText());
        LoggerUtility.info("The user interacts with sampleHeadingElement");

        frameMethods.switchToDefault();
        LoggerUtility.info("The user switches on default frame");

        frameMethods.switchFrameByElement(secondIFrameElement);
        LoggerUtility.info("The user switches on secondIFrameElement iframe");

        System.out.println(sampleHeadingElement.getText());
        LoggerUtility.info("The user interacts with sampleHeadingElement");

        frameMethods.switchToDefault();
        LoggerUtility.info("The user switches on default frame");
    }
}
