package iniitialize;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Listener  extends TestListenerAdapter {
    public ExtentReports report;
    public ExtentTest test;
    String filepath="src\\test\\testreport\\" +String.valueOf(System.currentTimeMillis())+"\\index.html";

    public void onTestStart(ITestResult iTestResult) {
        test=report.startTest(iTestResult.getMethod().getDescription());

    }

    public void onStart(ITestContext iTestContext) {
        report = new ExtentReports(filepath,true);
    }
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(LogStatus.INFO,"The test case passed");
        test.log(LogStatus.PASS,iTestResult.getTestName());
    }

    public void onTestFailure(ITestResult result) {
        String image = null;
        System.out.println(result.getMethod().getDescription());
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((Init) currentClass).getDriver();
        if (webDriver != null) {
          image = Util.takeScreenShot(result.getName(),webDriver);
          image = new File(image).getAbsolutePath();
            System.out.println(image);
        }

        test.log(LogStatus.FAIL,result.getName(),"Screenshot" +
                test.addScreenCapture(image));
        test.log(LogStatus.INFO,result.getThrowable().getMessage());

    }

    public void onTestSkipped(ITestResult result) {
        String image = null;
        System.out.println(result.getMethod().getDescription());
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((Init) currentClass).getDriver();
        if (webDriver != null) {
            image = Util.takeScreenShot(result.getName(),webDriver);
            image = new File(image).getAbsolutePath();
            System.out.println(image);
        }
        test.log(LogStatus.FAIL,result.getName(),"First" +
                test.addScreenCapture(image));

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }



    public void onFinish(ITestContext iTestContext) {
        report.endTest(test);
        report.flush();


    }



}