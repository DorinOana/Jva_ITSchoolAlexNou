package pages.elements;

import database.queries.WebTable;
import loggerUtility.LoggerUtility;
import objectData.model.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.elements.WebTableLocator;

import java.util.List;

public class WebTablePage extends ElementsPage {

    private final WebTable webTable;

    public WebTablePage(WebDriver driver) {
        super(driver);
        webTable = new WebTable();
    }

    public void addEntryIntoTable(WebTableObject webTableObject){
        elementMethods.clickLocator(WebTableLocator.addNewEntryLocator);
        LoggerUtility.info("The user clicks on addNewEntryElement");

        elementMethods.fillLocator(WebTableLocator.firstNameLocator, webTableObject.getFirstName());
        LoggerUtility.info("The user fills firstNameElement field with "+webTableObject.getFirstName()+" value");

        elementMethods.fillLocator(WebTableLocator.lastNameLocator, webTableObject.getLastName());
        LoggerUtility.info("The user fills lastNameElement field with "+webTableObject.getLastName()+" value");

        elementMethods.fillLocator(WebTableLocator.emailLocator, webTableObject.getEmail());
        LoggerUtility.info("The user fills emailElement field with "+webTableObject.getEmail()+" value");

        elementMethods.fillLocator(WebTableLocator.ageLocator, webTableObject.getAge());
        LoggerUtility.info("The user fills ageElement field with "+webTableObject.getAge()+" value");

        elementMethods.fillLocator(WebTableLocator.salaryLocator, webTableObject.getSalary());
        LoggerUtility.info("The user fills salaryElement field with "+webTableObject.getSalary()+" value");

        elementMethods.fillLocator(WebTableLocator.departmentLocator, webTableObject.getDepartment());
        LoggerUtility.info("The user fills departmentElement field with "+webTableObject.getDepartment()+" value");

        elementMethods.clickLocator(WebTableLocator.submitLocator);
        LoggerUtility.info("The user clicks on submitElement");

        List<WebElement> tableRowsList = elementMethods.getAllElements(WebTableLocator.tableRowsListLocator, true);
        webTableObject.setWebTableEntriesCount(tableRowsList.size());

        validateTableSize(webTableObject.getWebTableEntriesCount());
        validateNewEntry(webTableObject);
        webTable.insertTableObject(webTableObject);
        LoggerUtility.info("All the data are inserted with success into database");
    }

    private void validateTableSize(int expected){
        List<WebElement> tableRowsList = elementMethods.getAllElements(WebTableLocator.tableRowsListLocator, true);

        Assert.assertEquals(tableRowsList.size(), expected);
        LoggerUtility.info("The user validates the size of table: "+expected);
    }

    private void validateNewEntry(WebTableObject webTableObject){
        List<WebElement> tableRowsList = elementMethods.getAllElements(WebTableLocator.tableRowsListLocator, true);

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

        List<WebElement> tableRowsList = elementMethods.getAllElements(WebTableLocator.tableEditButtonsListLocator, true);

        elementMethods.clickElementJS(tableRowsList.get(webTableObject.getWebTableEntriesCount() - 1));
        LoggerUtility.info("The user clicks on editNewEntryElement");

        elementMethods.clearFillLocator(WebTableLocator.firstNameLocator, webTableObject.getFirstName());
        LoggerUtility.info("The user fills firstNameElement field with "+webTableObject.getFirstName()+" value");

        elementMethods.clearFillLocator(WebTableLocator.lastNameLocator, webTableObject.getLastName());
        LoggerUtility.info("The user fills lastNameElement field with "+webTableObject.getLastName()+" value");

        elementMethods.clearFillLocator(WebTableLocator.emailLocator, webTableObject.getEmail());
        LoggerUtility.info("The user fills emailElement field with "+webTableObject.getEmail()+" value");

        elementMethods.clearFillLocator(WebTableLocator.ageLocator, webTableObject.getAge());
        LoggerUtility.info("The user fills ageElement field with "+webTableObject.getAge()+" value");

        elementMethods.clearFillLocator(WebTableLocator.salaryLocator, webTableObject.getSalary());
        LoggerUtility.info("The user fills salaryElement field with "+webTableObject.getSalary()+" value");

        elementMethods.clearFillLocator(WebTableLocator.departmentLocator, webTableObject.getDepartment());
        LoggerUtility.info("The user fills departmentElement field with "+webTableObject.getDepartment()+" value");

        elementMethods.clickLocator(WebTableLocator.submitLocator);
        LoggerUtility.info("The user clicks on submitElement");

        validateTableSize(webTableObject.getWebTableEntriesCount());
        validateNewEntry(webTableObject);

        Integer latestIdEntry = webTable.getLatestIdBasedOnEntry();
        webTable.updateEntryById(latestIdEntry, webTableObject);
    }

    public void deleteNewEntry(WebTableObject webTableObject){
        List<WebElement> tableRowsList = elementMethods.getAllElements(WebTableLocator.tableDeleteButtonsListLocator, true);

        elementMethods.clickElementJS(tableRowsList.get(webTableObject.getWebTableEntriesCount() - 1));
        LoggerUtility.info("The user clicks on deleteNewEntryElement");
        validateTableSize(webTableObject.getWebTableEntriesCount() - 1);
    }
}
