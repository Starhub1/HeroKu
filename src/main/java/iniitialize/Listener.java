/*
package iniitialize;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listener implements ITestListener {

    public ExtentReports report;
    public ExtentTest test;
    String filepath="src\\test\\testreport\\" +String.valueOf(System.currentTimeMillis())+"\\index.html";

    public ExtentTest getTest() {
        return test;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Object ctx=iTestResult.getTestContext().getAttribute("report");
        String name =  iTestResult.getName();
        test= ((ExtentReports) ctx).startTest(name);
        iTestResult.getTestContext().setAttribute("logger",test);
    }

    @Override
    public void onTestSuccess(ITestResult res) {
            test.log(LogStatus.PASS,res.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult res) {


            String image = null;
            System.out.println(res.getMethod().getDescription());
            Object currentClass = res.getInstance();
            WebDriver webDriver = ((Init) currentClass).getDriver();
            if (webDriver != null) {
                image = Util.takeScreenShot(res.getName(),webDriver);
                image = new File(image).getAbsolutePath();
                System.out.println(image);
            }

            test.log(LogStatus.FAIL,res.getName(),"Screenshot" +
                    test.addScreenCapture(image));
            test.log(LogStatus.INFO,res.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext ctx) {
        report = new ExtentReports(filepath,true);
        ctx.setAttribute("report",report);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        report.endTest(test);
        report.flush();
    }
}
*/
