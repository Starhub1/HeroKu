package TestCase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import iniitialize.Init;

public class ContextMenu extends Init {

	@Test(description = "This is a sample test to verify the context menu:", testName = "contextMenu Verification")
	public void VerifyContextMenu() {
		logger = report.startTest("VerifyContextMenu");
		test.set(logger);
		logger.log(LogStatus.INFO, "Verify Context Menu");
		logger.log(LogStatus.PASS, "Browser Started");
		driver.get("http://the-internet.herokuapp.com/context_menu");
		WebElement el = driver.findElement(By.id("hot-spot"));
		logger.log(LogStatus.PASS, "search the element to click");
		el.click();
		Actions a = new Actions(driver);
		a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
		a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
		a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
		a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
		a.contextClick(el).sendKeys(Keys.ENTER).perform();
		logger.log(LogStatus.PASS, "Perform context click");
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		Assert.assertTrue(al.getText().contains("You selected a context menu"));
	}

}
