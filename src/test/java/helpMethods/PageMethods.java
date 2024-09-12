package helpMethods;

import org.openqa.selenium.WebDriver;

public class PageMethods extends BaseMethods{

    public PageMethods(WebDriver driver) {
        super(driver);
    }

    public void navigateToUrl(String url){
        waitForSeconds(3500);
        driver.navigate().to(url);
    }
}
