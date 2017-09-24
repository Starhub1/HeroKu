package iniitialize;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class Init{



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
	String filepath="src\\test\\testreport\\" +String.valueOf(System.currentTimeMillis())+"\\index.html";


	@BeforeSuite
	public void beforesuite(ITestContext ctx) {
		report = new ExtentReports(filepath,true);
		ctx.setAttribute("logger",logger);
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
		//options.addArguments("--headless");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}