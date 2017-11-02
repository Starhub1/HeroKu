package Initialize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Init {

	public WebDriver dr;
	public WebDriverWait wait;
	ChromeOptions options;
	public EventFiringWebDriver driver;
	public static ExtentReports report;
	public String filepath;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	public ExtentTest logger;
	private static List<WebDriverThread> webDriverThreadPool = Collections
			.synchronizedList(new ArrayList<WebDriverThread>());
	private static ThreadLocal<WebDriverThread> driverThread;

	public static EventFiringWebDriver getDriver() throws Exception {
		return driverThread.get().getDriver();
	}

	public static ExtentTest getLogger() {
		return test.get();
	}

	public ExtentTest getLogger(String testcaseName) {
		logger = report.startTest("Verify Drag and drop functionality");
		test.set(logger);
		return test.get();
	}

	@BeforeSuite
	public void beforesuite(XmlTest test) {
		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
			}
		};

		Util.setFilePath("test-results/");
		filepath = Util.getFilePath();
		report = new ExtentReports(filepath, true);
		System.out.println(test.getSuite().getName());
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