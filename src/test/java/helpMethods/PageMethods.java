package helpMethods;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class PageMethods {

    private WebDriver driver;

    @SneakyThrows
    public void navigateToUrl(String url){
        Thread.sleep(3500);
        driver.navigate().to(url);
    }
}
