package Initialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Init {
	private static String path;
	public static ExtentReports report;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>() ;

	private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());
	private static ThreadLocal<WebDriverThread> driverThread;

	public static EventFiringWebDriver getDriver() throws Exception {
		return driverThread.get().getDriver();
	}

	public static ExtentTest setLogger(String testcaseName) {
		test.set(report.startTest(testcaseName));
		return test.get();
	}

	public static void endTest() {
		report.endTest(test.get());
		report.flush();
	}
	public static ExtentTest getLogger() {
		return test.get();
	}

	@BeforeSuite
	public static void beforeSuite() throws IOException {

		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
			}
		};

		path = Util.getFilePath("test-results/");
		report = Reporter.createInstance(path);
	}

	@AfterSuite
	public void aftersuite() {
		for (WebDriverThread webDriverThread : webDriverThreadPool) {
			webDriverThread.quitDriver();
		}
		report.flush();
		report.close();
	}


	@AfterMethod
	public void tearDown() throws Exception {
		getDriver().manage().deleteAllCookies();

	}
}