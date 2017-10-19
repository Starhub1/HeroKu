package TestCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import iniitialize.Init;

public class TestlinkScript extends Init {

	@Test
	public void testlink() throws InterruptedException {
		String test = "'Order and Data Flow'";
		String xpath = "//span[contains(text()," + test + ")]/../../..//li";
		// logger = report.startTest("Blocking test cases in the testlink");
		// driver.get("http://blrqatestlink/testlink/index.php");
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login"))));
		// EventFiringWebDriver(driver.switchTo().window("CDwindow-bf6eea27-1d03-48e8-85c6-98f486a14bad"));
		super.setSessionId("0b6a73c870e9ef7d07691a406cf35c0e");
		driver.get("http://blrqatestlink/testlink/index.php");
		driver.findElement(By.id("login")).sendKeys("mohammed.nasir");
		driver.findElement(By.name("tl_password")).sendKeys("Qr:;@vDbk-52");
		driver.findElement(By.name("login_submit")).click();
		driver.switchTo().frame(driver.findElement(By.name("titlebar")));

		// Title Bar Frame
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("testproject"))));
		new Select(driver.findElement(By.name("testproject"))).selectByVisibleText("Tangoe Platform");
		driver.findElement(By.xpath("//a[text()='Test Execution']")).click();

		// Switch to Tree Frame mainframe
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.name("mainframe")));
		driver.switchTo().frame(driver.findElement(By.name("treeframe")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("doUpdateTree"))));
		driver.findElement(By.id("cbsetting_refresh_tree_on_action")).click();
		Thread.sleep(7000L);
		new Select(driver.findElement(By.name("setting_testplan"))).selectByVisibleText("TA_17_2_Regression");
		Thread.sleep(5000L);
		new Select(driver.findElement(By.name("filter_result_result"))).selectByVisibleText("Blocked");

		driver.findElement(By.id("doUpdateTree")).click();
		Thread.sleep(5000L);

		driver.findElement(By.id("expand_tree")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		List<WebElement> ele = driver.findElements(By.xpath(xpath));
		String currentWindow = driver.getWindowHandle();

		// Switch to workframe

		for (WebElement el : ele) {
			el.click();
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.name("workframe")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resultBox']/input[4]")));
			if (driver.findElements(By.xpath("//a/b[contains(text(),'255557')]")).size() == 0) {
				driver.findElement(By.xpath("(//img[@title='Link Existent Issue'])[1]")).click();
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				for (String w : driver.getWindowHandles()) {
					driver.switchTo().window(w);
					if (driver.getTitle() == "TestLink")
						break;
				}
				driver.findElement(By.id("bug_id")).sendKeys("255557 ");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				Thread.sleep(2000L);
				driver.findElement(By.xpath("//input[@type='button']")).click();
				driver.switchTo().window(currentWindow);
				driver.switchTo().frame(driver.findElement(By.name("mainframe")));
				driver.switchTo().frame(driver.findElement(By.name("treeframe")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
				continue;
			}
			driver.switchTo().parentFrame();
			driver.switchTo().frame(driver.findElement(By.name("treeframe")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		}

		// for (WebElement el : ele) {
		// el.click();
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame(driver.findElement(By.name("workframe")));
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='resultBox']/input[4]")));
		// if (driver.findElements(By.xpath("//div[text()='Not Run']")).size() >
		// 0) {
		// new
		// Select(driver.findElement(By.xpath("//td/select[contains(@id,'custom_field')]")))
		// .selectByVisibleText("17.2.0.54.3");
		// driver.findElement(By.xpath("//div[@class='resultBox']/input[4]")).click();
		// driver.findElement(By.xpath("//input[@value='Save
		// execution']")).click();
		// Thread.sleep(3000L);
		// driver.findElement(By.xpath("(//img[@title='Link Existent
		// Issue'])[1]")).click();
		// wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		// for (String w : driver.getWindowHandles()) {
		// driver.switchTo().window(w);
		// if (driver.getTitle() == "TestLink")
		// break;
		// }
		// driver.findElement(By.id("bug_id")).sendKeys("255557 ");
		// driver.findElement(By.xpath("//input[@type='submit']")).click();
		// Thread.sleep(2000L);
		// driver.findElement(By.xpath("//input[@type='button']")).click();
		// driver.switchTo().window(currentWindow);
		//
		// }
		// driver.switchTo().frame(driver.findElement(By.name("mainframe")));
		// driver.switchTo().frame(driver.findElement(By.name("treeframe")));
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		// }
	}

}
