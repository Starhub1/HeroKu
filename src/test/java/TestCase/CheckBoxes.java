package TestCase;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import iniitialize.Init;

public class CheckBoxes extends Init {

	@Parameters(value = "Browser")
	@Test(description = "To verify the Checkboxes values", testName = "Verify Checkbox functionality")
	public void VerifyCheckBoxLabel() {
		logger = report.startTest("Verify Checkbox functionality");
		logger.log(LogStatus.PASS, "Browser Started");
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		logger.log(LogStatus.PASS, "Navigated to the URL : \"http://the-internet.herokuapp.com/checkboxes\" ");
		String labels = driver.findElement(By.id("checkboxes")).getText();
		logger.log(LogStatus.PASS, "Sucessfully searched the element checkbox");
		String labelArr[] = labels.split("\n");
		for (String lbl : labelArr) {
			AssertJUnit.assertTrue(lbl.contains("checkbox"));
			logger.log(LogStatus.PASS, lbl);
		}
	}

}
