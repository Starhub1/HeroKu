package Initialize;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public enum DriverType implements DriverSetup {

	REMOTE {

		@Override
		public EventFiringWebDriver getWebDriverObject() throws MalformedURLException {
			// http://192.168.99.100:4444/wd/hub
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.acceptInsecureCerts();
			capabilities.acceptInsecureCerts();

			capabilities.setBrowserName("chrome");
			/*
			 * capabilities.setVersion("61.0"); capabilities.setCapability("enableVNC",
			 * true); capabilities.setCapability("enableVideo", true);
			 * capabilities.setCapability("start-maximized", true);
			 */

			RemoteWebDriver dr = new RemoteWebDriver(URI.create("http://192.168.99.100:32774/wd/hub").toURL(),
					capabilities);
			EventListener eventListener = new EventListener();
			EventFiringWebDriver driver = new EventFiringWebDriver(dr);
			driver.register(eventListener);
			return driver;
		}

	},

	CHROME {
		public EventFiringWebDriver getWebDriverObject() {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("incognito");
			// options.addArguments("--headless");

			System.setProperty("webdriver.chrome.driver", "src/test/Resource/chromedriver_win32/chromedriver.exe");
			WebDriver dr = new ChromeDriver(options);
			EventListener eventListener = new EventListener();
			EventFiringWebDriver driver = new EventFiringWebDriver(dr);
			driver.register(eventListener);
			return driver;
		}

	},
	FIREFOX {

		public EventFiringWebDriver getWebDriverObject() {
			System.setProperty("webdriver.gecko.driver", "src/test/Resource/geckodriver-v0.19.0-win32/geckodriver.exe");
			WebDriver dr = new FirefoxDriver();
			EventListener eventListener = new EventListener();
			EventFiringWebDriver driver = new EventFiringWebDriver(dr);
			driver.register(eventListener);
			return driver;

		}
	},
	IE {
		public EventFiringWebDriver getWebDriverObject() {

			System.setProperty("webdriver.ie.driver", "src/test/Resource/IEDriverServer_x64_3.6.0/IEDriverServer.exe");
			WebDriver dr = new InternetExplorerDriver();
			EventListener eventListener = new EventListener();
			EventFiringWebDriver driver = new EventFiringWebDriver(dr);
			driver.register(eventListener);
			return driver;

		}

	},
	OPERA {
		public EventFiringWebDriver getWebDriverObject() {
			// TODO Auto-generated method stub
			return null;
		}

	},
	SAFARI {
		public EventFiringWebDriver getWebDriverObject() {
			// TODO Auto-generated method stub
			return null;
		}
	},

	PHANTOMJS {

		public EventFiringWebDriver getWebDriverObject() {

			System.setProperty("phantomjs.binary.path",
					"/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");
			WebDriver dr = new PhantomJSDriver();
			dr.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			EventListener eventListener = new EventListener();
			EventFiringWebDriver driver = new EventFiringWebDriver(dr);
			driver.register(eventListener);
			return driver;

		}

	},
}
