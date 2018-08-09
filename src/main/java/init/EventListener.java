package init;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class EventListener extends AbstractWebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		ExtentTest logger = Init.getLogger();
		logger.log(Status.PASS, "Navigating to the url: " + url);
		System.out.println("Navigating to the url" + url + "'");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		ExtentTest logger = Init.getLogger();
		logger.log(Status.PASS, "Successfully  navigated  to the url: " + url);
		System.out.println("Navigated to the url :'" + url + "'");
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		/*
		 * JavascriptExecutor jse = ((JavascriptExecutor) driver); String text =
		 * (String) jse.executeScript("return arguments[0].text",element);
		 * System.out.printf("Searching for the element %s in the DOM", text);
		 */
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		/*
		 * JavascriptExecutor jse = ((JavascriptExecutor) driver); String text =
		 * (String)jse.executeScript("return arguments[0].text",element);
		 * System.out.printf("Successfully searched the element %s in the DOM ",text);
		 */
	}

	@Override
	public void beforeClickOn(WebElement ele, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String script = "var ofs = 0;var el = arguments[0];var winInterval = setInterval(function(){el.style.background = 'rgba(255,230,20,'+Math.abs(Math.sin(ofs))+')'; ofs += 0.15;	}, 1);		setTimeout(function(){el.style.background = 'none';clearInterval(winInterval)},300)";
		jse.executeScript(script, ele);
		String text = (String) jse
				.executeScript("return arguments[0].innerText || arguments[0].textContent || arguments[0].value", ele);
		ExtentTest logger = Init.getLogger();
		logger.log(Status.PASS, "Trying to Click on the Element : " + text);
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		try {
			JavascriptExecutor jse = ((JavascriptExecutor) driver);
			String text = (String) jse.executeScript(
					"return arguments[0].innerText || arguments[0].textContent || arguments[0].value", element);
			ExtentTest logger = Init.getLogger();
			logger.log(Status.PASS, "Successfully Clicked on the Element : " + text);

		} catch (Exception e) {
			ExtentTest logger = Init.getLogger();
			logger.log(Status.PASS, "Successfully Clicked the Element.");
		}
	}

	@Override
	public void beforeChangeValueOf(WebElement ele, WebDriver driver, CharSequence[] keysToSend) {
		ele.clear();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String script = "var ofs = 0;var el = arguments[0];var winInterval = setInterval(function(){el.style.background = 'rgba(255,230,20,'+Math.abs(Math.sin(ofs))+')'; ofs += 0.15;	}, 1);		setTimeout(function(){el.style.background = 'none';clearInterval(winInterval)},300)";
		jse.executeScript(script, ele);
		String text = (String) jse
				.executeScript("return arguments[0].innerText || arguments[0].textContent || arguments[0].value", ele);
		ExtentTest logger = Init.getLogger();
		logger.log(Status.PASS, "Trying to Enter the text :" + keysToSend + "on the element" + text);

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String text = (String) jse.executeScript(
				"return arguments[0].innerText || arguments[0].textContent || arguments[0].value", element);
		ExtentTest logger = Init.getLogger();
		logger.log(Status.PASS, "Successfuly entered the value " + keysToSend + "in the element" + text);
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
	}

	@Override
	public void onException(Throwable error, WebDriver driver) {
	}
}
