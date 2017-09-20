package iniitialize;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Init{


    public WebDriver dr;
    public WebDriverWait wait;
    public Reporter report;
    ExtentTest logger;

    public WebDriver getDriver() {
        return dr;
    }

    public ExtentTest getLogger() {
        return logger;
    }

    @BeforeTest
    public void beforesuite(ITestContext ctx) {
        report = new Reporter();
        report.createReport();
    }

    @AfterTest
    public void aftersuite() {
        report.closeReport();
        dr.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        logger= Reporter.report.startTest(String.valueOf("TestCase : " + Reporter.tcno++));
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.isSuccess())
        {
            logger.log(LogStatus.PASS,result.getName());
        }
        else {

            String image = null;
            System.out.println(result.getMethod().getDescription());
            Object currentClass = result.getInstance();
             dr = ((Init) currentClass).getDriver();
            if (dr != null) {
                image = Util.takeScreenShot(result.getName(),dr);
                image = new File(image).getAbsolutePath();
                System.out.println(image);
            }

            logger.log(LogStatus.FAIL,result.getName(),"Screenshot" +
                    logger.addScreenCapture(image));
            logger.log(LogStatus.FAIL,result.getThrowable().getMessage());

        }
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