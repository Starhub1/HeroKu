package Initialize;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public interface DriverSetup {

	EventFiringWebDriver getWebDriverObject();


	 default ChromeOptions getChromeOptions(){
		ChromeOptions options = new ChromeOptions();
		 options.addArguments("start-maximized");
		 options.addArguments("incognito");
		 // options.addArguments("--headless");
		 return options;
	}

}
