package iniitialize;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Init {

	public WebDriver driver;
	public WebDriverWait wait;
	ChromeOptions options;

	public WebDriver getDriver() {
		return driver;
	}

	public ExtentTest getLogger() {
		return logger;
	}

	public ExtentTest logger;
	public static ExtentReports report;


	public String filepath;

	@BeforeSuite
	public void beforesuite(XmlTest test) {
		Util.setFilePath("test-results/");
		filepath = Util.getFilePath();
		report = new ExtentReports(filepath, true);
		System.out.println(test.getSuite().getName());
	}

	@AfterSuite
	public void aftersuite() {
		report.endTest(logger);
		report.flush();
		driver.quit();
	}

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\Resource\\chromedriver_win32\\chromedriver.exe");
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("incognito");
		options.addArguments("–disable-images");
		// options.addArguments("--headless");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}