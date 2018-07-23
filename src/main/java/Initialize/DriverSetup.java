package Initialize;

import java.net.MalformedURLException;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public interface DriverSetup {
	EventFiringWebDriver getWebDriverObject() throws MalformedURLException;
}
