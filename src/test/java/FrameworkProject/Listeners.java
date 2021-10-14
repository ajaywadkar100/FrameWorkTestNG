package FrameworkProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.ExtentReportNG;
import util.base;

import java.io.IOException;

public class Listeners extends base implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReportNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult result) {

         test = extent.createTest(result.getMethod().getMethodName());
         extentTest.set(test);

    }

    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test Case Passed");

    }

    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        WebDriver driver = null;
        String testMethodName = result.getMethod().getMethodName();
        System.out.println(testMethodName);

        try
        {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) { }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver),result.getMethod().getMethodName());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

        extent.flush();

    }
}
