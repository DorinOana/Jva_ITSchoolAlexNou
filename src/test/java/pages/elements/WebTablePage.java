package pages.elements;

import database.queries.WebTable;
import logger.LoggerUtility;
import objectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class WebTablePage extends ElementsPage {

    private WebTable webTable;

    public WebTablePage(WebDriver driver) {
        super(driver);
        webTable = new WebTable();
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addNewEntryElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(xpath = "//div[@class='rt-tbody']//div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List<WebElement> tableRowsList;
    @FindBy(xpath = "//span[@title='Edit']")
    private List<WebElement> tableEditButtonsList;
    @FindBy(xpath = "//span[@title='Delete']")
    private List<WebElement> tableDeleteButtonsList;

    public void addEntryIntoTable(WebTableObject webTableObject){
        webTableObject.setWebTableEntriesCount(tableRowsList.size());

        elementMethods.clickElementJS(addNewEntryElement);
        LoggerUtility.info("The user clicks on addNewEntryElement");

        elementMethods.fillElement(firstNameElement, webTableObject.getFirstName());
        LoggerUtility.info("The user fills firstNameElement field with "+webTableObject.getFirstName()+" value");

        elementMethods.fillElement(lastNameElement, webTableObject.getLastName());
        LoggerUtility.info("The user fills lastNameElement field with "+webTableObject.getLastName()+" value");

        elementMethods.fillElement(emailElement, webTableObject.getEmail());
        LoggerUtility.info("The user fills emailElement field with "+webTableObject.getEmail()+" value");

        elementMethods.fillElement(ageElement, webTableObject.getAge());
        LoggerUtility.info("The user fills ageElement field with "+webTableObject.getAge()+" value");

        elementMethods.fillElement(salaryElement, webTableObject.getSalary());
        LoggerUtility.info("The user fills salaryElement field with "+webTableObject.getSalary()+" value");

        elementMethods.fillElement(departmentElement, webTableObject.getDepartment());
        LoggerUtility.info("The user fills departmentElement field with "+webTableObject.getDepartment()+" value");

        elementMethods.clickElement(submitElement);
        LoggerUtility.info("The user clicks on submitElement");

        webTableObject.setWebTableEntriesCount(tableRowsList.size());

        validateTableSize(webTableObject.getWebTableEntriesCount());
        validateNewEntry(webTableObject);
        webTable.insertTableObject(webTableObject);
    }

    private void validateTableSize(int expected){
        Assert.assertEquals(tableRowsList.size(), expected);
        LoggerUtility.info("The user validates the size of table: "+expected);
    }

    private void validateNewEntry(WebTableObject webTableObject){
        String newEntryTable = tableRowsList.get(webTableObject.getWebTableEntriesCount() - 1).getText();
        Assert.assertTrue(newEntryTable.contains(webTableObject.getFirstName()));
        LoggerUtility.info("The user validates the presence of "+webTableObject.getFirstName()+" value");

        Assert.assertTrue(newEntryTable.contains(webTableObject.getLastName()));
        LoggerUtility.info("The user validates the presence of "+webTableObject.getLastName()+" value");

        Assert.assertTrue(newEntryTable.contains(webTableObject.getAge()));
        LoggerUtility.info("The user validates the presence of "+webTableObject.getAge()+" value");

        Assert.assertTrue(newEntryTable.contains(webTableObject.getEmail()));
        LoggerUtility.info("The user validates the presence of "+webTableObject.getEmail()+" value");

        Assert.assertTrue(newEntryTable.contains(webTableObject.getSalary()));
        LoggerUtility.info("The user validates the presence of "+webTableObject.getSalary()+" value");

        Assert.assertTrue(newEntryTable.contains(webTableObject.getDepartment()));
        LoggerUtility.info("The user validates the presence of "+webTableObject.getDepartment()+" value");
    }

    public void modifyNewEntry(WebTableObject webTableObject){

        webTableObject.setDepartment("programming");
        webTableObject.setAge("29");

        elementMethods.clickElement(tableEditButtonsList.get(webTableObject.getWebTableEntriesCount() - 1));
        LoggerUtility.info("The user clicks on editNewEntryElement");

        elementMethods.clearFillElement(firstNameElement, webTableObject.getFirstName());
        LoggerUtility.info("The user fills firstNameElement field with "+webTableObject.getFirstName()+" value");

        elementMethods.clearFillElement(lastNameElement, webTableObject.getLastName());
        LoggerUtility.info("The user fills lastNameElement field with "+webTableObject.getLastName()+" value");

        elementMethods.clearFillElement(emailElement, webTableObject.getEmail());
        LoggerUtility.info("The user fills emailElement field with "+webTableObject.getEmail()+" value");

        elementMethods.clearFillElement(ageElement, webTableObject.getAge());
        LoggerUtility.info("The user fills ageElement field with "+webTableObject.getAge()+" value");

        elementMethods.clearFillElement(salaryElement, webTableObject.getSalary());
        LoggerUtility.info("The user fills salaryElement field with "+webTableObject.getSalary()+" value");

        elementMethods.clearFillElement(departmentElement, webTableObject.getDepartment());
        LoggerUtility.info("The user fills departmentElement field with "+webTableObject.getDepartment()+" value");

        elementMethods.clickElement(submitElement);
        LoggerUtility.info("The user clicks on submitElement");

        validateTableSize(webTableObject.getWebTableEntriesCount());
        validateNewEntry(webTableObject);

        Integer latestIdEntry = webTable.getLatestIdBasedOnEntry();
        webTable.updateEntryById(latestIdEntry, webTableObject);
    }

    public void deleteNewEntry(WebTableObject webTableObject){
        elementMethods.clickElement(tableDeleteButtonsList.get(webTableObject.getWebTableEntriesCount() - 1));
        LoggerUtility.info("The user clicks on deleteNewEntryElement");
        validateTableSize(webTableObject.getWebTableEntriesCount() - 1);
    }
}
