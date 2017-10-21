package TestCase;

import static Pages.DynamicControlLocator.btnAddRemove;
import static Pages.DynamicControlLocator.chkCheckbox;
import static Pages.DynamicControlLocator.lblMessage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.DynamicControlLocator;
import iniitialize.Init;

public class DynamicControls extends Init {
	DynamicControlLocator dynamicControlPage;

	@Test
	public void dynamicControltest() throws Exception {
		logger = report.startTest("Verify Dynamic control functionality", "");
		test.set(logger);
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		dynamicControlPage = new DynamicControlLocator(driver);
		assertEquals(driver.getTitle(), "The Internet");
		btnAddRemove.click();
		wait.until(ExpectedConditions.textToBePresentInElement(lblMessage, "It's gone!"));
		assertEquals(chkCheckbox.size(), 0);
		logger.log(LogStatus.FAIL, "The checkbox is still available");
		assertEquals(lblMessage.getText(), "It's gone!");
		logger.log(LogStatus.PASS, "The checkbox is not still available");

		btnAddRemove.click();
		wait.until(ExpectedConditions.textToBePresentInElement(lblMessage, "It's back!"));
		assertTrue(chkCheckbox.get(0).isDisplayed());
		assertEquals(lblMessage.getText(), "It's back!");
		logger.log(LogStatus.PASS, "The checkbox is not still available");
	}

}
