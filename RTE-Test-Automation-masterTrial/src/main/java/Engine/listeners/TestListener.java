package Engine.listeners;

import Engine.TestExtentReporting.ExtentReporterNG;
import Engine.common.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

//import Engine.testrail.TestRail;
//import Engine.testrail.TestRestAPI;

public class TestListener extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    Logger log = Logger.getLogger(TestListener.class);

    /*
    Runs anytime a test starts
     */
    @Override
    public void onTestStart(ITestResult result) {
        log.info("===============================================");
        log.info("START TEST :" + result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    /*
    Runs anytime a test completes successfully
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("===============================================");
        log.info("END TEST (SUCCESS): " + result.getMethod().getMethodName());
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    /*
    Runs anytime a test fails
     */
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("===============================================");
        log.info("END TEST (FAILED): " + result.getMethod().getMethodName());
        extentTest.get().fail(result.getThrowable());
        //WebDriver driver = null;
        String testMethodName = result.getMethod().getMethodName();
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {

        }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Runs anytime a test is skipped
     */
    @Override
    public void onTestSkipped(ITestResult result){
        log.info("===============================================");
        log.info("SKIPPED TEST :" + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();

    }



}
