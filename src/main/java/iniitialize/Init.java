package iniitialize;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Init {

	
	public  WebDriver dr;
	Util util;
	
public WebDriver getDriver() {
	return dr;
}

@BeforeClass
    public void setup() {

              System.setProperty("webdriver.chrome.driver", "src\\test\\Resource\\chromedriver_win32\\chromedriver.exe");
                dr = new ChromeDriver();

       

        dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        dr.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        dr.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    
    
@AfterClass
    public void tearDown() {
    	dr.quit();
    }


    
  }
