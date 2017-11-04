package TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import com.relevantcodes.extentreports.ExtentTest;
import io.qameta.allure.Step;
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
		ExtentTest logger = setLogger("Verify Checkbox functionality").assignAuthor("Mohammed Nasir").assignCategory("Category Regression");

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

	@Step("Verify the {0}  page")
	@Test()
	public void VerifyheaderoftheCheckboxPage() throws Exception {

		ExtentTest logger = setLogger("Verify Header of the Checkbox Page").assignAuthor("Mohammed Nasir").assignCategory("Category Regression");

		getDriver().get("http://the-internet.herokuapp.com/checkboxes");
		CheckboxPage = new CheckboxPage(getDriver());
		
		String header = CheckboxPage.getheader();
		
		logger.log(LogStatus.INFO, "Verify Header of the Checkbox Page");
		assertEquals("Checkboxes", header);
		logger.log(LogStatus.PASS, "Header of the Checkbox page is :"+header);
	}
}
