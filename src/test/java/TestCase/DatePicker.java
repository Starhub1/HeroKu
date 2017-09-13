package TestCase;

import Pages.DatePickerLocator;
import iniitialize.Init;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatePicker extends Init {
    WebDriver driver;
    WebDriverWait wait;
    Init init;
    DatePickerLocator datePickerLocator;

    @BeforeClass
    public void setup() {
    	driver = super.getDriver();
        driver.get("http://jqueryui.com/datepicker/");
        datePickerLocator = new DatePickerLocator(driver);
        wait = new WebDriverWait(driver, 30);

    }

    @Test
    public void SelectADate() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));
        datePickerLocator.datepicker.sendKeys("08/15/2018");
        datePickerLocator.datepicker.sendKeys(Keys.ENTER);
        System.out.println("the selected date is : " + datePickerLocator.datepicker.getText());
    }

}
