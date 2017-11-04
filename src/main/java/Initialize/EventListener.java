package Initialize;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EventListener extends AbstractWebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {}
	public void afterAlertAccept(WebDriver driver) {}
	public void afterAlertDismiss(WebDriver driver) {}
	public void beforeAlertDismiss(WebDriver driver) {}

	public void beforeNavigateTo(String url, WebDriver driver) {
		/*ExtentTest logger = Init.getLogger();
		logger.log(LogStatus.PASS, "Navigating to the url: " + url);
		System.out.println("Navigating to the url" + url + "'");
	*/}

	public void afterNavigateTo(String url, WebDriver driver) {
		/*ExtentTest logger = Init.getLogger();
		logger.log(LogStatus.PASS, "Successfully  navigated  to the url: " + url);
		System.out.println("Navigated to the url :'" + url + "'");
	*/}

	public void beforeNavigateBack(WebDriver driver) {}
	public void afterNavigateBack(WebDriver driver) {}
	public void beforeNavigateForward(WebDriver driver) {}
	public void afterNavigateForward(WebDriver driver) {}
	public void beforeNavigateRefresh(WebDriver driver) {}
	public void afterNavigateRefresh(WebDriver driver) {}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		/*JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String text = (String) jse.executeScript("return arguments[0].text",element);
		System.out.printf("Searching for the element %s in the DOM", text);*/
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		/*JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String text = (String)jse.executeScript("return arguments[0].text",element);
		 System.out.printf("Successfully searched the element %s in the DOM ",text);*/
	}

	public void beforeClickOn(WebElement ele, WebDriver driver) {
		/*JavascriptExecutor jse = (JavascriptExecutor) driver;
		String script = "var ofs = 0;var el = arguments[0];var winInterval = setInterval(function(){el.style.background = 'rgba(255,230,20,'+Math.abs(Math.sin(ofs))+')'; ofs += 0.15;	}, 1);		setTimeout(function(){el.style.background = 'none';clearInterval(winInterval)},300)";
		jse.executeScript(script, ele);*/
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		/*ExtentTest logger = Init.getLogger();
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String text = (String)jse.executeScript("return arguments[0].text",element);
		logger.log(LogStatus.PASS,"Successfully Clicked on the Element : " + text );
	*/}

	public void beforeChangeValueOf(WebElement ele, WebDriver driver, CharSequence[] keysToSend) {
		/*JavascriptExecutor jse = (JavascriptExecutor) driver;
		String script = "var ofs = 0;var el = arguments[0];var winInterval = setInterval(function(){el.style.background = 'rgba(255,230,20,'+Math.abs(Math.sin(ofs))+')'; ofs += 0.15;	}, 1);		setTimeout(function(){el.style.background = 'none';clearInterval(winInterval)},300)";
		jse.executeScript(script, ele);*/

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		/*ExtentTest logger = Init.getLogger();
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String text = (String)jse.executeScript("return arguments[0].text",element);
		logger.log(LogStatus.PASS,"Successfuly entered the value "+ keysToSend + "in the element" + text );
	*/}

	public void beforeScript(String script, WebDriver driver) {}
	public void afterScript(String script, WebDriver driver) {}
	public void onException(Throwable error, WebDriver driver) {}
}
