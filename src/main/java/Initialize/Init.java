package Initialize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Init {
	public static ExtentReports report;
	public static ThreadLocal<Reporter> test ;

	private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());
	private static ThreadLocal<WebDriverThread> driverThread;

	public static EventFiringWebDriver getDriver() throws Exception {
		return driverThread.get().getDriver();
	}

	public static ExtentTest setLogger(String testcaseName) {
		test.get().setLogger(testcaseName);
		return getLogger();
	}

	public static void endTest() {
		test.get().endTest();
	}
	public static ExtentTest getLogger() {
		return test.get().getLogger();
	}

	@BeforeSuite
	public static void beforesuite() {

		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
			}
		};

		test= new ThreadLocal<Reporter>() {
			@Override
			protected Reporter initialValue() {
				Util.setFilePath("test-results/");
				report = new ExtentReports(Util.getFilePath(), true);
				Reporter reporter = new Reporter();
				return reporter;
			}
		};

	}

	@AfterSuite
	public void aftersuite() {
		for (WebDriverThread webDriverThread : webDriverThreadPool) {
			webDriverThread.quitDriver();
		}
	}


	@AfterMethod
	public void tearDown() throws Exception {
		getDriver().manage().deleteAllCookies();

	}
}