package Initialize;

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
		ExtentTest test = Init.getLogger();
		test.log(LogStatus.PASS,  "PASS");
	}

	@Override
	public void onTestFailure(ITestResult res) {
		String image = null;
		System.out.println(res.getMethod().getDescription());
		try {
			driver = Init.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ExtentTest test = Init.getLogger();
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
			test.log(LogStatus.FAIL, res.getThrowable());
		}
	}

	@Override
	public void onTestSkipped(ITestResult res) {
		try {
			driver = Init.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		test = Init.report.startTest(res.getName());
		if (driver != null) {
			test.log(LogStatus.SKIP, res.getName());
			test.log(LogStatus.SKIP, res.getThrowable());
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
