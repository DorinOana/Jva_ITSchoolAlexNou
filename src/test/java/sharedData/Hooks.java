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
    public synchronized void initiateTestReport(){
        ExtentUtility.initiateReport();
    }

    @BeforeMethod
    public synchronized void initializeObjects(){
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        ExtentUtility.createTest(testName);

        initializeDriver();
        PropertiesFile propertiesFile = new PropertiesFile("/inputTestData/" + testName + "Data");
        testData = propertiesFile.getAllValues();
    }

    @AfterMethod
    public synchronized void closeBrowser(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            ExtentUtility.attachTestLog(testName, result.getThrowable().getMessage(), getDriver());
        }
        quitDriver();
        ExtentUtility.finishTest(testName);
        LoggerUtility.endTestCase(testName);
    }

    @AfterSuite
    public synchronized void mergeRegressionLogs(){
        LoggerUtility.mergeLogFilesIntoOne();
        ExtentUtility.generateReport();
    }
}
