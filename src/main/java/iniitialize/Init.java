package iniitialize;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Init extends RemoteWebDriver {

	public WebDriver dr;
	public WebDriverWait wait;
	FirefoxOptions options;
	public EventFiringWebDriver driver;
	public String nodeURL = "http://10.80.59.107:5555/wd/hub";

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
	public void setup() throws MalformedURLException {
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
		options = new FirefoxOptions();
		options.addArguments("start-maximized");
		options.addArguments("incognito");
		options.addArguments("–disable-images");
		options.addArguments("disable-infobars");
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		// options.addArguments("--headless");
		// super.setSessionId("0b6a73c870e9ef7d07691a406cf35c0e");
		dr = new RemoteWebDriver(new URL(nodeURL), capability);
		// super.setSessionId("0b6a73c870e9ef7d07691a406cf35c0e");

		wait = new WebDriverWait(dr, 50);
		dr.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
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