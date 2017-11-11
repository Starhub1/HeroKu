package Initialize;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Initialize.Util.setFilePath;


public class Init {
    private static String path;
    public static ExtentReports report;
    public static ThreadLocal<ExtentTest> test=new ThreadLocal<>();

    private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());
    private static ThreadLocal<WebDriverThread> driverThread;

    public static EventFiringWebDriver getDriver() throws Exception {
        return driverThread.get().getDriver();
    }

    public static ExtentTest setLogger(String testcaseName) {
        test.set(report.createTest(testcaseName));
        return test.get();
    }

    public static void endTest() {
        report.flush();
    }

    public static ExtentTest getLogger() {
        return test.get();
    }

    @BeforeSuite
    public static void beforesuite() throws IOException {

        driverThread = new ThreadLocal<WebDriverThread>() {
            @Override
            protected WebDriverThread initialValue() {
                WebDriverThread webDriverThread = new WebDriverThread();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            }
        };

        path = setFilePath("test-results/");
        report = Reporter.createInstance(path);

    }

    @AfterSuite
    public void aftersuite() {
        for (WebDriverThread webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }


    @AfterMethod
    public void tearDown() throws Exception {
        getDriver().manage().deleteAllCookies();

    }
}