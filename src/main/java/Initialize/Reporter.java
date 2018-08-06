package Initialize;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance("test-output/extent.html");

		return extent;
	}

	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(false);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Page Object Model Report");
		htmlReporter.config().setTheme(Theme.DARK);
		// htmlReporter.setAppendExisting(true);
		htmlReporter.config().setDocumentTitle("HeroKu App Testing");
		htmlReporter.config().setCSS("body{color:blue}");
		htmlReporter.config().setReportName("HeroKu Test App");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}
}
