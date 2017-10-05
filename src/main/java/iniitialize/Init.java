package iniitialize;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Init {

	public WebDriver dr;
	public WebDriverWait wait;
	ChromeOptions options;
	public EventFiringWebDriver driver;

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
		// driver.quit();
	}

	@BeforeClass
	public void setup() {
		InputStream is = Init.class.getResourceAsStream("/chromedriver_win32/chromedriver.exe");
		String path = System.getProperty("java.io.tmpdir") + "chromedriver.exe";
		Path temdir = Paths.get(path);
		if (java.nio.file.Files.notExists(temdir)) {
			try {
				java.nio.file.Files.copy(is, temdir, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
				e.getMessage();
			}
		}
		System.setProperty("webdriver.chrome.driver", temdir.toString());
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("incognito");
		options.addArguments("–disable-images");
		// options.addArguments("--headless");
		dr = new ChromeDriver(options);
		wait = new WebDriverWait(dr, 30);
		dr.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		dr.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		EventListener eventListener = new EventListener();
		driver = new EventFiringWebDriver(dr);
		driver.register(eventListener);

	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}