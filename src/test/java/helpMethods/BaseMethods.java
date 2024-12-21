package helpMethods;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public class BaseMethods {

    protected WebDriver driver;

    public BaseMethods(WebDriver driver){
        this.driver = driver;
    }

    @SneakyThrows(Exception.class)
    public void waitForSeconds(long seconds){
        Thread.sleep(seconds);
    }
}
