package pages.forms;

import database.queries.PracticeFormTable;
import loggerUtility.LoggerUtility;
import objectData.model.PracticeFormObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.forms.PracticeFormLocators;

import java.util.List;

public class PracticeFormPage extends FormsPage {

    public PracticeFormTable practiceFormTable;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
        practiceFormTable = new PracticeFormTable();
    }

    public void fillEntireForm(PracticeFormObject practiceFormObject) {
        elementMethods.fillLocator(PracticeFormLocators.firstNameLocator, practiceFormObject.getFirstName());
        LoggerUtility.info("The user fills firstNameElement field with " + practiceFormObject.getFirstName() + " value");

        elementMethods.fillLocator(PracticeFormLocators.lastNameLocator, practiceFormObject.getLastName());
        LoggerUtility.info("The user fills lastNameElement field with " + practiceFormObject.getLastName() + " value");

        elementMethods.fillLocator(PracticeFormLocators.emailLocator, practiceFormObject.getEmail());
        LoggerUtility.info("The user fills emailElement field with " + practiceFormObject.getEmail() + " value");

        fillGender(practiceFormObject.getGender());
        LoggerUtility.info("The user fills genderElement field with " + practiceFormObject.getGender() + " value");

        elementMethods.fillLocator(PracticeFormLocators.numberLocator, practiceFormObject.getMobile());
        LoggerUtility.info("The user fills numberElement field with " + practiceFormObject.getMobile() + " value");

        fillSubjects(practiceFormObject.getSubjects());
        LoggerUtility.info("The user fills subjectsElement field with " + practiceFormObject.getSubjects() + " value");

        fillHobbies(practiceFormObject.getHobbies());
        LoggerUtility.info("The user fills hobbiesElement field with " + practiceFormObject.getHobbies() + " value");

        fillDateOfBirth(practiceFormObject.getDateOfBirth());
        LoggerUtility.info("The user fills dateOfBirthElement field with " + practiceFormObject.getDateOfBirth() + " value");

        elementMethods.fillLocator(PracticeFormLocators.addressLocator, practiceFormObject.getAddress());
        LoggerUtility.info("The user fills addressElement field with " + practiceFormObject.getAddress() + " value");

        fillState(practiceFormObject.getState());
        LoggerUtility.info("The user fills stateElement field with " + practiceFormObject.getState() + " value");

        fillCity(practiceFormObject.getCity());
        LoggerUtility.info("The user fills cityElement field with " + practiceFormObject.getCity() + " value");

        elementMethods.clickLocatorJS(PracticeFormLocators.submitLocator);
        LoggerUtility.info("The user clicks on submitElement field");

        validateFinalTableValues(practiceFormObject);
        practiceFormTable.insertTableObject(practiceFormObject);
        LoggerUtility.info("All the data were added into database");
    }

    private void fillGender(String value) {
        List<WebElement> genderOptionsList = elementMethods.getAllElements(PracticeFormLocators.genderOptionsListLocator, true);
        switch (value) {
            case "Male":
                elementMethods.clickElementJS(genderOptionsList.get(0));
                break;
            case "Female":
                elementMethods.clickElementJS(genderOptionsList.get(1));
                break;
            case "Other":
                elementMethods.clickElementJS(genderOptionsList.get(2));
                break;
        }
    }

    private void fillSubjects(String value) {
        elementMethods.fillLocator(PracticeFormLocators.subjectsLocator, value);
        elementMethods.fillLocator(PracticeFormLocators.subjectsLocator, String.valueOf(Keys.ENTER));
    }

    private void fillHobbies(String value) {
        elementMethods.scrollDownLocator(500);
        List<WebElement> hobbiesOptionsList = elementMethods.getAllElements(PracticeFormLocators.hobbiesOptionsListLocator, true);
        switch (value) {
            case "Sports":
                elementMethods.clickElementJS(hobbiesOptionsList.get(0));
                break;
            case "Reading":
                elementMethods.clickElementJS(hobbiesOptionsList.get(1));
                break;
            case "Music":
                elementMethods.clickElementJS(hobbiesOptionsList.get(2));
                break;
        }
    }

    private void fillState(String value) {
        elementMethods.clickLocatorJS(PracticeFormLocators.stateLocator);
        elementMethods.fillLocator(PracticeFormLocators.stateInputLocator, value);
        elementMethods.fillLocator(PracticeFormLocators.stateInputLocator, String.valueOf(Keys.ENTER));
    }

    private void fillCity(String value) {
        elementMethods.clickLocatorJS(PracticeFormLocators.cityLocator);
        elementMethods.fillLocator(PracticeFormLocators.cityInputLocator, value);
        elementMethods.fillLocator(PracticeFormLocators.cityInputLocator, String.valueOf(Keys.ENTER));
    }

    private void fillDateOfBirth(String value) {
        String[] splitDate = value.split(" ");

        elementMethods.clickLocator(PracticeFormLocators.dateOfBirthLocator);
        elementMethods.selectLocator(PracticeFormLocators.dateOfBirthMonthLocator, splitDate[1]);
        elementMethods.selectLocator(PracticeFormLocators.dateOfBirthYearLocator, splitDate[2]);

        List<WebElement> dateDropDownDaysList = elementMethods.getAllElements(PracticeFormLocators.dateDropDownDaysListLocator, true);
        dateDropDownDaysList.stream()
                .filter(element -> element.getText().equals(splitDate[0]))
                .findFirst()
                .orElseThrow(null)
                .click();
    }

    private void validateFinalTableValues(PracticeFormObject practiceFormObject) {
        List<WebElement> thankYouTableList = elementMethods.getAllElements(PracticeFormLocators.thankYouTableListLocator, true);

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

        elementMethods.clickLocatorJS(PracticeFormLocators.closeLocator);
    }
}
