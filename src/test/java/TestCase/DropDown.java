package TestCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import iniitialize.Init;

public class DropDown extends Init {

	Select dropdown;
	List<WebElement> options;

	@Test()
	public void VerifyDropDownValues() {

		logger = report.startTest("Verify Drop Down Values");
		test.set(logger);
		logger.log(LogStatus.PASS, "Browser Started");
		driver.get("http://the-internet.herokuapp.com/dropdown");
		logger.log(LogStatus.PASS, "Successuly navigated to the URL:");
		dropdown = new Select(driver.findElement(By.id("dropdown")));
		logger.log(LogStatus.PASS, "Search element suceess");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("dropdown")));
		options = dropdown.getOptions();
		for (WebElement o : options)
			System.out.println(o.getText());

	}

	@Test(dependsOnMethods = { "VerifyDropDownValues" })
	public void SelectAvalue() {
		logger = report.startTest("Select a value");
		test.set(logger);
		logger.log(LogStatus.INFO, "Select the vaule 1 from the drop down");
		dropdown.selectByValue("1");
		String s = dropdown.getFirstSelectedOption().toString();
		logger.log(LogStatus.PASS, "Verify the selected value");
		System.out.println("This is the select value " + s);
		logger.log(LogStatus.PASS, "PASSED");
	}

	@Test(dependsOnMethods = { "methodFailed" })
	public void methodSkipped() {
		logger = report.startTest("This test case will skipped");
		test.set(logger);
		System.out.println("This method skipped");
	}

	@Test(alwaysRun = true)
	public void methodFailed() {
		logger = report.startTest("This testcase will failed");
		test.set(logger);
		Assert.assertTrue(false);
	}

}