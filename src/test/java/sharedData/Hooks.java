package sharedData;

import extentUtility.ExtentUtility;
import logger.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import propertyUtility.PropertiesFile;

import java.util.HashMap;

public class Hooks extends SharedData{

    public String testName;
    public HashMap<String, String> testData;

    @BeforeSuite
    public void initiateTestReport(){
        ExtentUtility.initiateReport();
    }

    @BeforeMethod
    public void initializeObjects(){
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        ExtentUtility.createTest(testName);

        initializeDriver();
        PropertiesFile propertiesFile = new PropertiesFile("/inputTestData/" + testName + "Data");
        testData = propertiesFile.getAllValues();
    }

    @AfterMethod
    public void closeBrowser(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            ExtentUtility.attachTestLog(testName, result.getThrowable().getMessage(), getDriver());
            LoggerUtility.error(result.getThrowable().getMessage());
        }
        quitDriver();
        ExtentUtility.finishTest(testName);
        LoggerUtility.endTestCase(testName);
    }

    @AfterSuite
    public void mergeRegressionLogs(){
        LoggerUtility.mergeLogFilesIntoOne();
        ExtentUtility.generateReport();
    }
}
