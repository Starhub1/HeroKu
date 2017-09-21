package iniitialize;

import java.io.File;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Init {



	public WebDriver driver;
	public WebDriverWait wait;

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
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}