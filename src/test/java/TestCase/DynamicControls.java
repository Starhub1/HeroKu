package TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import Pages.DynamicControlPage;
import Initialize.Init;

public class DynamicControls extends Init {

	@Test
	public void dynamicControltestRemovingCheckbox() throws Exception {
		ExtentTest logger = setLogger("Verify Dynamic control functionality -Removing the checkbox");


		getDriver().get("http://the-internet.herokuapp.com/dynamic_controls");
		DynamicControlPage dynamicControlPage = new DynamicControlPage(getDriver());

		logger.log(Status.INFO,"Verify Removing the checkbox");
		dynamicControlPage.removetheCheckbox();
		assertEquals(dynamicControlPage.getMessagefortheButtonClick(), "It's gone!");
		assertFalse(dynamicControlPage.IsCheckboxPresent());
		logger.log(Status.PASS, "The checkbox is removed successfully");
		logger.log(Status.PASS,"The text in message is " + dynamicControlPage.getMessagefortheButtonClick());

	}

	@Test()
	public void dynamicControltestAddingTheCheckox() throws Exception {
		ExtentTest logger = setLogger("Verify Dynamic control functionality -Adding the checkbox");

		DynamicControlPage dynamicControlPage = new DynamicControlPage(getDriver());
		getDriver().get("http://the-internet.herokuapp.com/dynamic_controls");
		dynamicControlPage.removetheCheckbox();

		logger.log(Status.PASS,"Verify adding the checkbox back ");
		dynamicControlPage.addTheCheckboxagain();
		assertEquals(dynamicControlPage.getMessagefortheButtonClick(), "It's back!");
		assertTrue(dynamicControlPage.IsCheckboxPresent());
		logger.log(Status.PASS, "The checkbox is added successfully");
		logger.log(Status.PASS,"The text in message is " + dynamicControlPage.getMessagefortheButtonClick());

	}

}
