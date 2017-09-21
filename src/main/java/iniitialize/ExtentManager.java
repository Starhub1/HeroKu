package iniitialize;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	public ExtentReports report;
	public ExtentTest test;
	String filepath = "src\\test\\testreport\\" + String.valueOf(System.currentTimeMillis()) + "\\index.html";

	public synchronized void createReport() {
		report = new ExtentReports(filepath, true);
	}

	public synchronized void createTest(String desc) {
		test = report.startTest(desc);
	}

	public void closeReport() {
		report.endTest((ExtentTest) test);
		report.flush();
	}
}
