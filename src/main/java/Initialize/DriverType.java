package Initialize;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public enum DriverType implements DriverSetup {

	CHROME {
		WebDriver dr;
		EventFiringWebDriver driver;

		@Override
		public EventFiringWebDriver getWebDriverObject() {
			System.setProperty("webdriver.chrome.driver", "src/test/Resource/chromedriver_win32/chromedriver.exe");
			dr = new ChromeDriver(getChromeOptions());
			EventListener eventListener = new EventListener();
			driver = new EventFiringWebDriver(dr);
			driver.register(eventListener);
			return driver;
		}


	},
	FIREFOX {
		WebDriver dr;
		EventFiringWebDriver driver;

		@Override
		public EventFiringWebDriver getWebDriverObject() {
			System.setProperty("webdriver.gecko.driver", "src/test/Resource/geckodriver-v0.19.0-win32/geckodriver.exe");
			dr = new FirefoxDriver();
			EventListener eventListener = new EventListener();
			driver = new EventFiringWebDriver(dr);
			driver.register(eventListener);
			return driver;

		}
	},
	IE {
		WebDriver dr;
		EventFiringWebDriver driver;

		@Override
		public EventFiringWebDriver getWebDriverObject() {

			System.setProperty("webdriver.ie.driver",
					"src/test/Resource/IEDriverServer_Win32_3.6.0/IEDriverServer.exe");
			dr = new InternetExplorerDriver();
			EventListener eventListener = new EventListener();
			driver = new EventFiringWebDriver(dr);
			driver.register(eventListener);
			return driver;

		}

	},
	OPERA {

		@Override
		public EventFiringWebDriver getWebDriverObject() {
			// TODO Auto-generated method stub
			return null;
		}

	},
	SAFARI {

		@Override
		public EventFiringWebDriver getWebDriverObject() {
			// TODO Auto-generated method stub
			return null;
		}
	},

	PHANTOMJS {
		WebDriver dr;
		ChromeOptions options;
		EventFiringWebDriver driver;

		@Override
		public EventFiringWebDriver getWebDriverObject() {
			InputStream is = Init.class
					.getResourceAsStream("/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");
			String path = System.getProperty("java.io.tmpdir") + "phantomjs.exe";
			Path temdir = Paths.get(path);
			if (java.nio.file.Files.notExists(temdir)) {
				try {
					java.nio.file.Files.copy(is, temdir, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
					e.getMessage();
				}
			}
			System.setProperty("phantomjs.binary.path", temdir.toString());
			dr = new PhantomJSDriver();
			dr.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			EventListener eventListener = new EventListener();
			driver = new EventFiringWebDriver(dr);
			driver.register(eventListener);
			return driver;

		}

	},

}
