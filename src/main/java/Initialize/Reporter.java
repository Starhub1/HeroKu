package Initialize;

import com.relevantcodes.extentreports.ExtentTest;

public class Reporter {
    ExtentTest logger;
    public void setLogger(String testcaseName){
        logger = Init.report.startTest(testcaseName);
    }

    public ExtentTest getLogger() {
        return logger;
    }

    public void endTest() {
        Init.report.endTest(logger);
        Init.report.flush();
    }
}
