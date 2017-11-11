package Initialize;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener implements ITestListener {


	@Override
	public void onTestStart(ITestResult res) {
	}

	@Override
	public void onTestSuccess(ITestResult res) {
		ExtentTest test = Init.getLogger();
		test.log(Status.PASS,  "PASS");
		Init.endTest();
	}

	@Override
	public void onTestFailure(ITestResult res) {
		EventFiringWebDriver driver=null;
		String image = null;
		System.out.println(res.getMethod().getDescription());
		try {
			driver = ((Init) res.getInstance()).getDriver();
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
				test.log(Status.WARNING, "Screenshot" );
			try {
				test.addScreenCaptureFromPath(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.log(Status.WARNING, res.getThrowable().getLocalizedMessage());
		}
		else {
			try {
				test.log(Status.FAIL, "Screenshot"  );
				test.addScreenCaptureFromPath(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.log(Status.FAIL, res.getThrowable());
		}

		Init.endTest();
	}

	@Override
	public void onTestSkipped(ITestResult res) {
		/*EventFiringWebDriver driver = null;
		try {
			driver = ((Init) res.getInstance()).getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ExtentTest test = Init.report.startTest(res.getName());
		if (driver != null) {
			test.log(LogStatus.SKIP, res.getName());
			test.log(LogStatus.SKIP, res.getThrowable());
		}
		Init.endTest();*/

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
