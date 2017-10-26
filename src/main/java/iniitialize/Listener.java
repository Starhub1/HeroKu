package iniitialize;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listener implements ITestListener {

	public ExtentTest test;
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult res) {
		test = (ExtentTest) res.getAttribute("logger");
	}

	@Override
	public void onTestSuccess(ITestResult res) {
		Object currentClass = res.getInstance();
		ExtentTest test = ((Init) currentClass).getLogger();
		test.log(LogStatus.PASS, res.getName());
	}

	@Override
	public void onTestFailure(ITestResult res) {
		String image = null;
		System.out.println(res.getMethod().getDescription());
		Object currentClass = res.getInstance();
		try {
			driver = ((Init) currentClass).getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ExtentTest test = ((Init) currentClass).getLogger();
		if (driver != null) {
			image = Util.takeScreenShot(res.getName(), driver);
			image = new File(image).getAbsolutePath();
			System.out.println(image);
		}
		String exception = res.getThrowable().getClass().getSimpleName();
		if (exception.equalsIgnoreCase("NoSuchElementException")) {
			test.log(LogStatus.ERROR, res.getName(), "Screenshot" + test.addScreenCapture(image));
			test.log(LogStatus.ERROR, "Element Not Found Exception", res.getThrowable().getLocalizedMessage());
		} else {
			test.log(LogStatus.FAIL, res.getName(), "Screenshot" + test.addScreenCapture(image));
			test.log(LogStatus.FAIL, res.getThrowable().getLocalizedMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult res) {
		Object currentClass = res.getInstance();
		try {
			driver = Init.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		test = Init.report.startTest(res.getName());
		if (driver != null) {
			test.log(LogStatus.SKIP, res.getName());
			test.log(LogStatus.SKIP, res.getThrowable().getMessage());
		}

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	@Override
	public void onStart(ITestContext ctx) {
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
	}
}
