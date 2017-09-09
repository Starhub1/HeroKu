package Iniitialize;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Init {

    WebDriver dr;

    public Init(WebDriver driver) {
        this.dr = driver;
    }

    public WebDriver setup(String url, String browser) {

        switch (browser.toLowerCase()) {
            case "edge":
                System.setProperty("webdriver.edge.driver", "src\\test\\Resource\\MicrosoftWebDriver.exe");
                dr = new EdgeDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\nasir\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
                dr = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\nasir\\Downloads\\Compressed\\geckodriver-v0.18.0-win64\\geckodriver.exe");
                dr = new FirefoxDriver();
                break;
        }

        dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        dr.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        dr.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        dr.get(url);
        //dr.manage().window().maximize();
        return dr;
    }


    public void tearDown() {
        dr.quit();
    }


}
