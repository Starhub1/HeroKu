package TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Initialize.Init;
import Pages.CheckboxPage;

public class CheckBoxes extends Init {

	CheckboxPage CheckboxPage;
	List<WebElement> checkboxes;

	@Test()
	public void VerifyCheckBoxFunctionality() throws Exception {
		ExtentTest logger = setLogger("Verify Checkbox functionality").assignAuthor("Mohammed Nasir")
				.assignCategory("Category Regression");

		getDriver().get("http://the-internet.herokuapp.com/checkboxes");
		CheckboxPage = new CheckboxPage(getDriver());

		logger.log(Status.INFO, "Select Option 1 from the checkbox list");
		CheckboxPage.selectCheckbox(5);
		assertTrue(CheckboxPage.isSelected(1));
		logger.log(Status.PASS, "Option 1 Selected Succesfully");

		logger.log(Status.INFO, "De-Select Option 1 from the checkbox list");
		CheckboxPage.deSelectCheckbox(1);
		assertFalse(CheckboxPage.isSelected(1));
		logger.log(Status.PASS, "Option 1 De-Selected Succesfully");
	}

	@Test()
	public void VerifyheaderoftheCheckboxPage() throws Exception {

		ExtentTest logger = setLogger("Verify Header of the Checkbox Page").assignAuthor("Mohammed Nasir")
				.assignCategory("Category Regression");

		getDriver().get("http://the-internet.herokuapp.com/checkboxes");
		CheckboxPage = new CheckboxPage(getDriver());

		String header = CheckboxPage.getheader();

		logger.log(Status.INFO, "Verify Header of the Checkbox Page");
		assertEquals("Checkboxes", header);
		logger.log(Status.PASS, "Header of the Checkbox page is :" + header);
	}
}
