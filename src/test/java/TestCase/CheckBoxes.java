package TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.CheckboxPage;
import Initialize.Init;

public class CheckBoxes extends Init {
	
	CheckboxPage CheckboxPage;
	List<WebElement> checkboxes;

	
	@Test()
	public void VerifyCheckBoxFunctionality() throws Exception {
		logger = report.startTest("Verify Checkbox functionality");
		test.set(logger);
		
		getDriver().get("http://the-internet.herokuapp.com/checkboxes");
		CheckboxPage = new CheckboxPage(getDriver());
		
		logger.log(LogStatus.INFO, "Select Option 1 from the checkbox list");
		CheckboxPage.selectCheckbox(5);
		assertTrue(CheckboxPage.isSelected(1));
		logger.log(LogStatus.PASS, "Option 1 Selected Succesfully");
		
		logger.log(LogStatus.INFO, "De-Select Option 1 from the checkbox list");
		CheckboxPage.deSelectCheckbox(1);
		assertFalse(CheckboxPage.isSelected(1));
		logger.log(LogStatus.PASS,"Option 1 De-Selected Succesfully");
	}

	@Test()
	public void VerifyheaderoftheCheckboxPage() throws Exception {
		
		logger = report.startTest("Verify Header of the Checkbox Page");
		test.set(logger);
		
		getDriver().get("http://the-internet.herokuapp.com/checkboxes");
		CheckboxPage = new CheckboxPage(getDriver());
		
		String header = CheckboxPage.getheader();
		
		logger.log(LogStatus.INFO, "Verify Header of the Checkbox Page");
		assertEquals("Checkboxes", header);
		logger.log(LogStatus.PASS, "Header of the Checkbox page is :"+header);
	}
}
