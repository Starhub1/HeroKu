package driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private String curdir = System.getProperty("user.dir");

	public  WebDriver getInstance() {
		String browser = getBrowserName();
		return instantiate(browser);

	}

	private String getBrowserName() {
		String browser = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(curdir + "\\config\\app.properties")));
			browser = prop.getProperty("browser");
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return browser;

	}

	private  WebDriver instantiate(String browser) {
		WebDriver driver = null;
		switch (browser.toLowerCase()) {
		case "remote":
			System.setProperty("webdriver.chrome.driver", curdir + "\\Resources\\chromedriver.exe");
			driver = new RemoteWebDriver(DesiredCapabilities.chrome());
			break;
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("incognito");
			// options.addArguments("--headless");
			System.setProperty("webdriver.chrome.driver",
					curdir + "\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", curdir + "\\src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", curdir + "\\src\\main\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", curdir + "\\src\\main\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
}
