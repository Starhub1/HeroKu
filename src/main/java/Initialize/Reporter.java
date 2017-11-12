package Initialize;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

import java.io.File;

public class Reporter {
    private static ExtentReports reports;

    public static ExtentReports getInstance(String fileName) {
        if (reports == null)
            createInstance(fileName);

        return reports;
    }

    public static ExtentReports createInstance(String fileName) {
        reports = new ExtentReports(fileName, false, NetworkMode.ONLINE);
        reports.loadConfig(new File(("config.xml")));

        return reports;

    }
}
