package iniitialize;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Reporter {

    public static ExtentReports report;
    public volatile ExtentTest test;
    public static int tcno = 1;
    String filepath="src\\test\\testreport\\" +String.valueOf(System.currentTimeMillis())+"\\index.html";

    public synchronized ExtentTest getTest() {
        return test;
    }

    public synchronized void createReport() {
        report = new ExtentReports(filepath,true);
    }

    public synchronized void startTest(String testcaseName) {
        test=report.startTest(testcaseName);
    }

    public void closeReport () {
        report.endTest(test);
        report.flush();
    }


}
