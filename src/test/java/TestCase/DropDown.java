package TestCase;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.DropDownPage;
import Initialize.Init;

public class DropDown extends Init {

	List<String> expectedvalues = Arrays.asList("Please select an option","Option 1","Option 2");

	@Test()
	public void VerifyDropDownValues() throws Exception {
		
		logger = report.startTest("Verify Drop Down Values in the Drop Down Page");
		test.set(logger);
		
		getDriver().get("http://the-internet.herokuapp.com/dropdown");
		DropDownPage DropdownPage = new DropDownPage();
		
		logger.log(LogStatus.INFO, "Verify all the options in the drop down");
		List <String> actualvalues = DropdownPage.getAlltheValuesfromtheDropdown();
		assertEquals(actualvalues, expectedvalues);

		logger.log(LogStatus.PASS, "All the options are as expected "+ actualvalues);



	}

	@Test(dependsOnMethods = { "VerifyDropDownValues" })
	public void SelectAvaluefromtheDropDown() throws Exception {
		
		logger = report.startTest("Select a value from the Drop Down");
		test.set(logger);
		
		getDriver().get("http://the-internet.herokuapp.com/dropdown");
		DropDownPage DropdownPage = new DropDownPage();
		
		logger.log(LogStatus.INFO, "Verify Select the value 1 from the drop down");
		DropdownPage.SelectAValuefromTheDropDown(1);
		assertEquals(DropdownPage.getSelectedValDropDown(), "Option 1");
		logger.log(LogStatus.PASS, "The Selected value in the drop down is " + DropdownPage.getSelectedValDropDown());
		
		
	}

	@Test(dependsOnMethods = { "methodFailed" })
	public void methodSkipped() throws Exception {
		logger = report.startTest("This test case will skipped");
		test.set(logger);
		
		getDriver().get("http://the-internet.herokuapp.com/dropdown");
		
		System.out.println("This method skipped");
	}

	@Test(alwaysRun = true)
	public void methodFailed() throws Exception {
		logger = report.startTest("This testcase will failed");
		test.set(logger);
		
		getDriver().get("http://the-internet.herokuapp.com/dropdown");
		Assert.assertTrue(false);
		
		
		
	}

}