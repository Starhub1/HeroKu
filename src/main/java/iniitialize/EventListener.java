package iniitialize;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class EventListener extends AbstractWebDriverEventListener {
	ExtentTest test;
	ExtentReports report = Init.report;
	private WebDriver webDriver;

	@BeforeMethod
	public void beforemethod(ITestResult res) {
		Object currentClass = res.getInstance();
		test = ((Init) currentClass).getLogger();
	}

	public void beforeAlertAccept(WebDriver driver) {

	}

	public void afterAlertAccept(WebDriver driver) {

	}

	public void afterAlertDismiss(WebDriver driver) {

	}

	public void beforeAlertDismiss(WebDriver driver) {

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");

	}

	public void beforeNavigateBack(WebDriver driver) {

	}

	public void afterNavigateBack(WebDriver driver) {

	}

	public void beforeNavigateForward(WebDriver driver) {

	}

	public void afterNavigateForward(WebDriver driver) {

	}

	public void beforeNavigateRefresh(WebDriver driver) {

	}

	public void afterNavigateRefresh(WebDriver driver) {

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		/*
		 * System.out.printf("Searching for the element %s in the DOM",
		 * element.getText() ); System.out.println("");
		 */

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		/*
		 * System.out.printf("Successfully searched the element %s in the DOM "
		 * ,element.getText()); System.out.println("");
		 */
	}

	public void beforeClickOn(WebElement ele, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String script = "var ofs = 0;var el = arguments[0];var winInterval = setInterval(function(){el.style.background = 'rgba(255,230,20,'+Math.abs(Math.sin(ofs))+')'; ofs += 0.15;	}, 1);		setTimeout(function(){el.style.background = 'none';clearInterval(winInterval)},300)";
		jse.executeScript(script, ele);
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
	}

	public void beforeChangeValueOf(WebElement ele, WebDriver driver, CharSequence[] keysToSend) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String script = "var ofs = 0;var el = arguments[0];var winInterval = setInterval(function(){el.style.background = 'rgba(255,230,20,'+Math.abs(Math.sin(ofs))+')'; ofs += 0.15;	}, 1);		setTimeout(function(){el.style.background = 'none';clearInterval(winInterval)},300)";
		jse.executeScript(script, ele);

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	public void beforeScript(String script, WebDriver driver) {

	}

	public void afterScript(String script, WebDriver driver) {

	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Error occurred: " + error);
	}
}
