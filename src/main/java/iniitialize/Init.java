package iniitialize;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Init {


    public WebDriver dr;
    public WebDriverWait wait;

    public WebDriver getDriver() {
        return dr;
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\Resource\\chromedriver_win32\\chromedriver.exe");
        dr = new ChromeDriver();
        wait = new WebDriverWait(dr, 30);
        dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        dr.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        dr.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }


    @AfterClass
    public void tearDown() {
        dr.quit();
    }



}