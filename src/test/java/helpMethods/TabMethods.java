package helpMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TabMethods extends BaseMethods{

    public TabMethods(WebDriver driver) {
        super(driver);
    }

    public Integer getNumberOfTabsOpened(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        return tabs.size();
    }

    public void switchToASpecificTabByIndex (int value){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(value));
    }
}
