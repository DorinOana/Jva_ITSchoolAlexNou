package pages.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class PracticeFormPage extends FormsPage{

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(xpath = "//label[contains(@for,'gender')]")
    private List<WebElement> genderOptionsList;
    @FindBy(id = "userNumber")
    private WebElement numberElement;
    @FindBy(id = "dateOfBirthInput")
    private WebElement
}
