package iniitialize;

import static iniitialize.DriverType.valueOf;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverThread {
	private EventFiringWebDriver webdriver;
	private DriverType selectedDriverType;

	private final DriverType defaultDriverType = DriverType.CHROME;
	private final String browser = "CHROME";
	private final String operatingSystem = System.getProperty("os.name").toUpperCase();
	private final String systemArchitecture = System.getProperty("os.arch");

	public EventFiringWebDriver getDriver() throws Exception {
		if (null == webdriver) {
			selectedDriverType = determineEffectiveDriverType();
			DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
			instantiateWebDriver(desiredCapabilities);
		}

		return webdriver;
	}

	public void quitDriver() {
		if (null != webdriver) {
			webdriver.quit();
		}
	}

	private DriverType determineEffectiveDriverType() {
		DriverType driverType = defaultDriverType;
		try {
			driverType = valueOf(browser);
		} catch (IllegalArgumentException ignored) {
			System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
		} catch (NullPointerException ignored) {
			System.err.println("No driver specified, defaulting to '" + driverType + "'...");
		}
		return driverType;
	}

	private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) throws MalformedURLException {
		System.out.println(" ");
		System.out.println("Current Operating System: " + operatingSystem);
		System.out.println("Current Architecture: " + systemArchitecture);
		System.out.println("Current Browser Selection: " + selectedDriverType);
		System.out.println(" ");
		webdriver = selectedDriverType.getWebDriverObject(desiredCapabilities);
	}

}
