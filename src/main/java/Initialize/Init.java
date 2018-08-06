package Initialize;

import static Initialize.Util.setFilePath;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mongodb.annotations.ThreadSafe;

import driver.DriverFactory;

public class Init {
	private static String path;
	public static ExtentReports report;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	public static ThreadLocal<WebDriver> driverT = new ThreadLocal<>();

	public static ExtentTest setLogger(String testcaseName) {
		test.set(report.createTest(testcaseName));
		return test.get();
	}

	public static void endTest() {
		report.flush();
	}

	public static ExtentTest getLogger() {
		return test.get();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method - The thread id is" + Thread.currentThread().getId());
		driverT.set(new DriverFactory().getInstance());
	}

	@BeforeSuite
	public static void beforesuite() throws IOException {
		System.out.println("before suite - The thread id is" + Thread.currentThread().getId());
		path = setFilePath("test-results/");
		report = Reporter.createInstance(path);

	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("After suite - The thread id is" + Thread.currentThread().getId());
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("After Method - The thread id is" + Thread.currentThread().getId());
		getDriver().quit();

	}

	public  WebDriver getDriver() {
		return driverT.get();
	}
}