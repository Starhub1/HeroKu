package Initialize;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

public enum DriverType implements DriverSetup {

    CHROME {
        public EventFiringWebDriver getWebDriverObject() {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("incognito");
            options.addArguments("--headless");

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
            EventFiringWebDriver  driver = new EventFiringWebDriver(dr);
            driver.register(eventListener);
            return driver;

        }
    },
    IE {
        public EventFiringWebDriver getWebDriverObject() {

            System.setProperty("webdriver.ie.driver",
                    "src/test/Resource/IEDriverServer_x64_3.6.0/IEDriverServer.exe");
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

            System.setProperty("phantomjs.binary.path", "/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");
            WebDriver dr = new PhantomJSDriver();
            dr.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            EventListener eventListener = new EventListener();
            EventFiringWebDriver  driver = new EventFiringWebDriver(dr);
            driver.register(eventListener);
            return driver;

        }

    },
}
