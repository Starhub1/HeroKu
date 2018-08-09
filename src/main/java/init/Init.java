package init;

import static init.Util.setFilePath;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import driver.DriverFactory;

public class Init {
	private static String path;
	public static ExtentReports report;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	public static ThreadLocal<WebDriver> driverT = new ThreadLocal<>();
	private static Map<Long, WebDriver> map = new ConcurrentHashMap<>();

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
		long threadId = Thread.currentThread().getId();
		System.out.println("before Method - The thread id is" + threadId);
		if(map.get(threadId) == null) {
			driverT.set(new DriverFactory().getInstance());
			map.put(threadId, driverT.get());
		}else {
			map.get(threadId);
		}
		
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
	
	@AfterTest
	public void afterTest() {
		//map.entrySet().stream().forEach(d->d.getValue().quit());
		map.values().stream().forEach(WebDriver::quit);
	}
	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("before Method - The thread id is" + Thread.currentThread().getId());
		getDriver().manage().deleteAllCookies();
		System.gc();

	}

	public  WebDriver getDriver() {
		return driverT.get();
	}
}