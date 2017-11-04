package TestCase;

import static org.testng.Assert.assertEquals;

import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.DatePickerPage;
import Initialize.Init;

public class DatePicker extends Init {

	DatePickerPage datePickerLocator;

	@Test()
	public void VerifySelectADate() throws Exception {
		ExtentTest logger = Init.setLogger("Select JQuery Date").assignAuthor("Mohammed Nasir").assignCategory("Category Regression");

		getDriver().get("http://jqueryui.com/datepicker/");
		datePickerLocator = new DatePickerPage(getDriver());
		
		logger.log(LogStatus.INFO, "Verify Entering a date 08/15/2018 in the date Field");
		datePickerLocator.selectAdateintheDateFieled("08/15/2018");
		logger.log(LogStatus.INFO, "The date 08/15/2018 is selected successfuly");
		
	}
	
	@Test()
	public void verifyheaderoftheDatePickerPage() throws Exception {
		ExtentTest logger = setLogger("Verify header of the Date Picker Page.").assignAuthor("Mohammed Nasir").assignCategory("Category Regression");

		getDriver().get("http://jqueryui.com/datepicker/");
		datePickerLocator = new DatePickerPage(getDriver());
		
		logger.log(LogStatus.INFO, "Verify Header of the Page");
		String header = datePickerLocator.getPageheader();
		assertEquals(header, "Datepicker");
		logger.log(LogStatus.PASS, "Header of the Page is "+ header);
		
	}
}
