package TestCase;

import Iniitialize.Init;
import Pages.DatePickerLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatePicker {
    WebDriver driver;
    WebDriverWait wait;
    Init init;
    DatePickerLocator datePickerLocator;

    @BeforeClass
    public void setup() {
        init = new Init(driver);
        driver = init.setup("http://jqueryui.com/datepicker/", "chrome");
        datePickerLocator = new DatePickerLocator(driver);
        wait = new WebDriverWait(driver, 30);

    }

    @AfterClass
    public void teardown() {
        init.tearDown();
    }

    @Test
    public void SelectADate() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));
//        datepicker = driver.findElement(By.id("datepicker"));
        datePickerLocator.datepicker.sendKeys("08/15/2018");
        datePickerLocator.datepicker.sendKeys(Keys.ENTER);
        System.out.println("the selected date is : " + datePickerLocator.datepicker.getText());
    }

}
