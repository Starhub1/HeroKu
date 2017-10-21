package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.DatePickerLocator;
import iniitialize.Init;

public class DatePicker extends Init {

	DatePickerLocator datePickerLocator;

	@Test(description = "To verify Select a Date function")
	public void SelectADate() {
		logger = report.startTest("Select JQuery Date");
		test.set(logger);
		driver.get("http://jqueryui.com/datepicker/");
		datePickerLocator = new DatePickerLocator(driver);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));
		logger.log(LogStatus.PASS, "Switch to the frame", "Frame swithch successfult");
		datePickerLocator.datepicker.sendKeys("08/15/2018");
		datePickerLocator.datepicker.sendKeys(Keys.ENTER);
		System.out.println("the selected date is : " + datePickerLocator.datepicker.getText());
	}
}
