package TestCase;

import Pages.DatePickerLocator;
import iniitialize.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DatePicker extends Init {

    DatePickerLocator datePickerLocator = new DatePickerLocator(driver);

    @Test(description = "To verify Select a Date function")
    public void SelectADate() {
        logger = report.startTest("Select JQuery Date");
        driver.get("http://jqueryui.com/datepicker/");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));
        datePickerLocator.datepicker.sendKeys("08/15/2018");
        datePickerLocator.datepicker.sendKeys(Keys.ENTER);
        System.out.println("the selected date is : " + datePickerLocator.datepicker.getText());
    }
}
