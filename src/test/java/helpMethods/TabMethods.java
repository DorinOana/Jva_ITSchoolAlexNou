package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

@AllArgsConstructor
public class TabMethods {

    private WebDriver driver;

    public Integer getNumberOfTabsOpened(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        return tabs.size();
    }

    public void switchToASpecificTabByIndex (int value){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(value));
    }
}
