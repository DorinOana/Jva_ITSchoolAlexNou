package pages.forms;

import database.queries.PracticeFormTable;
import loggerUtility.LoggerUtility;
import objectData.model.PracticeFormObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class PracticeFormPage extends FormsPage {

    public PracticeFormTable practiceFormTable;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
        practiceFormTable = new PracticeFormTable();
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
    @FindBy(id = "subjectsInput")
    private WebElement subjectsElement;
    @FindBy(xpath = "//label[contains(@for,'hobbies')]")
    private List<WebElement> hobbiesOptionsList;
    @FindBy(id = "currentAddress")
    private WebElement addressElement;
    @FindBy(xpath = "//div[text()='Select State']")
    private WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;
    @FindBy(xpath = "//div[text()='Select City']")
    private WebElement cityElement;
    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement successMessageElement;
    @FindBy(css = ".table tr")
    private List<WebElement> thankYouTableList;
    @FindBy(id = "closeLargeModal")
    private WebElement closeElement;
    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class, 'day--outside-month')) and @role='option']")
    private List<WebElement> dateDropDownDaysList;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;
    @FindBy(css = ".react-datepicker__month-select")
    private WebElement dateOfBirthMonthElement;
    @FindBy(css = ".react-datepicker__year-select")
    private WebElement dateOfBirthYearElement;

    public void fillEntireForm(PracticeFormObject practiceFormObject) {
        elementMethods.fillElement(firstNameElement, practiceFormObject.getFirstName());
        LoggerUtility.info("The user fills firstNameElement field with " + practiceFormObject.getFirstName() + " value");

        elementMethods.fillElement(lastNameElement, practiceFormObject.getLastName());
        LoggerUtility.info("The user fills lastNameElement field with " + practiceFormObject.getLastName() + " value");

        elementMethods.fillElement(emailElement, practiceFormObject.getEmail());
        LoggerUtility.info("The user fills emailElement field with " + practiceFormObject.getEmail() + " value");

        fillGender(practiceFormObject.getGender());
        LoggerUtility.info("The user fills genderElement field with " + practiceFormObject.getGender() + " value");

        elementMethods.fillElement(numberElement, practiceFormObject.getMobile());
        LoggerUtility.info("The user fills numberElement field with " + practiceFormObject.getMobile() + " value");

        fillSubjects(practiceFormObject.getSubjects());
        LoggerUtility.info("The user fills subjectsElement field with " + practiceFormObject.getSubjects() + " value");

        fillHobbies(practiceFormObject.getHobbies());
        LoggerUtility.info("The user fills hobbiesElement field with " + practiceFormObject.getHobbies() + " value");

        fillDateOfBirth(practiceFormObject.getDateOfBirth());
        LoggerUtility.info("The user fills dateOfBirthElement field with " + practiceFormObject.getDateOfBirth() + " value");

        elementMethods.fillElement(addressElement, practiceFormObject.getAddress());
        LoggerUtility.info("The user fills addressElement field with " + practiceFormObject.getAddress() + " value");

        fillState(practiceFormObject.getState());
        LoggerUtility.info("The user fills stateElement field with " + practiceFormObject.getState() + " value");

        fillCity(practiceFormObject.getCity());
        LoggerUtility.info("The user fills cityElement field with " + practiceFormObject.getCity() + " value");

        elementMethods.clickElementJS(submitElement);
        LoggerUtility.info("The user clicks on submitElement field");

        validateFinalTableValues(practiceFormObject);
        practiceFormTable.insertTableObject(practiceFormObject);
        LoggerUtility.info("All the data were added into database");
    }

    private void fillGender(String value) {
        switch (value) {
            case "Male":
                elementMethods.clickElement(genderOptionsList.get(0));
                break;
            case "Female":
                elementMethods.clickElement(genderOptionsList.get(1));
                break;
            case "Other":
                elementMethods.clickElement(genderOptionsList.get(2));
                break;
        }
    }

    private void fillSubjects(String value) {
        elementMethods.fillElement(subjectsElement, value);
        elementMethods.fillElement(subjectsElement, String.valueOf(Keys.ENTER));
    }

    private void fillHobbies(String value) {
        elementMethods.scrollDownElement(500);
        switch (value) {
            case "Sports":
                elementMethods.clickElement(hobbiesOptionsList.get(0));
                break;
            case "Reading":
                elementMethods.clickElement(hobbiesOptionsList.get(1));
                break;
            case "Music":
                elementMethods.clickElement(hobbiesOptionsList.get(2));
                break;
        }
    }

    private void fillState(String value) {
        elementMethods.clickElementJS(stateElement);
        elementMethods.fillElement(stateInputElement, value);
        elementMethods.fillElement(stateInputElement, String.valueOf(Keys.ENTER));
    }

    private void fillCity(String value) {
        elementMethods.clickElementJS(cityElement);
        elementMethods.fillElement(cityInputElement, value);
        elementMethods.fillElement(cityInputElement, String.valueOf(Keys.ENTER));
    }

    private void fillDateOfBirth(String value) {
        String[] splitDate = value.split(" ");

        elementMethods.clickElement(dateOfBirthElement);
        elementMethods.selectElement(dateOfBirthMonthElement, splitDate[1]);
        elementMethods.selectElement(dateOfBirthYearElement, splitDate[2]);

        String proba = dateDropDownDaysList.get(0).getText();
        dateDropDownDaysList.stream()
                .filter(element -> element.getText().equals(splitDate[0]))
                .findFirst()
                .orElseThrow(null)
                .click();
    }

    private void validateFinalTableValues(PracticeFormObject practiceFormObject) {
        Assert.assertTrue(thankYouTableList.get(1).getText().contains("Student Name"));
        Assert.assertTrue(thankYouTableList.get(1).getText().contains(practiceFormObject.getFirstName()));
        Assert.assertTrue(thankYouTableList.get(1).getText().contains(practiceFormObject.getLastName()));
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getFirstName() + " value");
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getLastName() + " value");

        Assert.assertTrue(thankYouTableList.get(2).getText().contains("Student Email"));
        Assert.assertTrue(thankYouTableList.get(2).getText().contains(practiceFormObject.getEmail()));
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getEmail() + " value");

        Assert.assertTrue(thankYouTableList.get(3).getText().contains("Gender"));
        Assert.assertTrue(thankYouTableList.get(3).getText().contains(practiceFormObject.getGender()));
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getGender() + " value");

        Assert.assertTrue(thankYouTableList.get(4).getText().contains("Mobile"));
        Assert.assertTrue(thankYouTableList.get(4).getText().contains(practiceFormObject.getMobile()));
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getMobile() + " value");

        Assert.assertTrue(thankYouTableList.get(5).getText().contains("Date of Birth"));
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getDateOfBirth() + " value");

        Assert.assertTrue(thankYouTableList.get(6).getText().contains("Subjects"));
        Assert.assertTrue(thankYouTableList.get(6).getText().contains(practiceFormObject.getSubjects()));
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getSubjects() + " value");

        Assert.assertTrue(thankYouTableList.get(7).getText().contains("Hobbies"));
        Assert.assertTrue(thankYouTableList.get(7).getText().contains(practiceFormObject.getHobbies()));
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getHobbies() + " value");

        Assert.assertTrue(thankYouTableList.get(9).getText().contains("Address"));
        Assert.assertTrue(thankYouTableList.get(9).getText().contains(practiceFormObject.getAddress()));
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getAddress() + " value");

        Assert.assertTrue(thankYouTableList.get(10).getText().contains("State and City"));
        Assert.assertTrue(thankYouTableList.get(10).getText().contains(practiceFormObject.getState()));
        Assert.assertTrue(thankYouTableList.get(10).getText().contains(practiceFormObject.getCity()));
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getState() + " value");
        LoggerUtility.info("The user validates the presence of " + practiceFormObject.getCity() + " value");

        elementMethods.clickElementJS(closeElement);
    }
}
