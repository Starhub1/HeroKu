package iniitialize;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public interface DriverSetup {

	EventFiringWebDriver getWebDriverObject(DesiredCapabilities desiredcapabilities);

	DesiredCapabilities getDesiredCapabilities();

}
