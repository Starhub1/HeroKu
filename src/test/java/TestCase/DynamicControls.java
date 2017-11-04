package TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.DynamicControlPage;
import Initialize.Init;

public class DynamicControls extends Init {

	@Test
	public void dynamicControltestRemovingCheckbox() throws Exception {
		ExtentTest logger = setLogger("Verify Dynamic control functionality -Removing the checkbox");


		getDriver().get("http://the-internet.herokuapp.com/dynamic_controls");
		DynamicControlPage dynamicControlPage = new DynamicControlPage(getDriver());

		logger.log(LogStatus.INFO,"Verify Removing the checkbox");
		dynamicControlPage.removetheCheckbox();
		assertEquals(dynamicControlPage.getMessagefortheButtonClick(), "It's gone!");
		assertFalse(dynamicControlPage.IsCheckboxPresent());
		logger.log(LogStatus.PASS, "The checkbox is removed successfully");
		logger.log(LogStatus.PASS,"The text in message is " + dynamicControlPage.getMessagefortheButtonClick());

	}

	@Test()
	public void dynamicControltestAddingTheCheckox() throws Exception {
		ExtentTest logger = setLogger("Verify Dynamic control functionality -Adding the checkbox");

		DynamicControlPage dynamicControlPage = new DynamicControlPage(getDriver());
		getDriver().get("http://the-internet.herokuapp.com/dynamic_controls");
		dynamicControlPage.removetheCheckbox();

		logger.log(LogStatus.PASS,"Verify adding the checkbox back ");
		dynamicControlPage.addTheCheckboxagain();
		assertEquals(dynamicControlPage.getMessagefortheButtonClick(), "It's back!");
		assertTrue(dynamicControlPage.IsCheckboxPresent());
		logger.log(LogStatus.PASS, "The checkbox is added successfully");
		logger.log(LogStatus.PASS,"The text in message is " + dynamicControlPage.getMessagefortheButtonClick());

	}

}
