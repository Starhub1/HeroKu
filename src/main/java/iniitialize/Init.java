package iniitialize;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Init {

	public WebDriver driver;
	public WebDriverWait wait;
	public Reporter report;
	public ExtentTest logger;

	public WebDriver getDriver() {
		return driver;
	}

	public ExtentTest getLogger() {
		return logger;
	}

	@BeforeTest
	public void beforesuite(ITestContext ctx) {
		report = new Reporter();
		report.createReport();
	}

	@AfterTest
	public void aftersuite() {
		report.closeReport();
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		logger = Reporter.report.startTest(String.valueOf("TestCase : " + Reporter.tcno++));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.isSuccess()) {
			logger.log(LogStatus.PASS, result.getName());
		} else {

			String image = null;
			System.out.println(result.getMethod().getDescription());
			Object currentClass = result.getInstance();
			driver = ((Init) currentClass).getDriver();
			if (driver != null) {
				image = Util.takeScreenShot(result.getName(), driver);
				image = new File(image).getAbsolutePath();
				System.out.println(image);
			}

			logger.log(LogStatus.FAIL, result.getName(), "Screenshot" + logger.addScreenCapture(image));
			logger.log(LogStatus.FAIL, result.getThrowable().getMessage());

		}
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