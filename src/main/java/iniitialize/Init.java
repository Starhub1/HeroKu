package iniitialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

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
	public void setup() throws IOException {
		
		
		InputStream is = Init.class.getResourceAsStream("/chromedriver_win32/chromedriver.exe");
		
		String tempDir = System.getProperty("java.io.tmpdir")+"chromedriver.exe";
		java.nio.file.Path path = Paths.get(tempDir);
		java.nio.file.Files.exists(path);
		if(java.nio.file.Files.notExists(path)) {
			java.nio.file.Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);			
		}		
		//FileUtils.copyInputStreamToFile(is, f);
		System.setProperty("webdriver.chrome.driver", path.toString());
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		System.out.println(capabilities.getBrowserName());
		System.out.println(capabilities.getVersion());
		System.out.println(capabilities.getPlatform());
		capabilities.setJavascriptEnabled(true);
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		//options.addArguments("incognito");
		//options.addArguments("–disable-images");
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