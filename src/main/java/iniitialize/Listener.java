package iniitialize;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {

@Override
public void onTestFailure(ITestResult result){
    Object currentClass = result.getInstance();
    WebDriver webDriver = ((Init) currentClass).getDriver();
    if (webDriver != null){
    	Util.takeScreenShot(result.getName() + "Failed", webDriver);
        }
    }

@Override
public void onTestSkipped(ITestResult result) {
	Object currentClass = result.getInstance();
	WebDriver webDriver = ((Init) currentClass).getDriver();
    if (webDriver != null){
    	Util.takeScreenShot(result.getName() + "Skipped", webDriver);
}
}}