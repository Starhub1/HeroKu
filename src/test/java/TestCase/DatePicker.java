package TestCase;

import iniitialize.Init;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DatePicker extends Init {
    WebDriver driver;
    WebDriverWait wait;
    Init init;
    //DatePickerLocator datePickerLocator;

    @Test(description = "To verify Select a Date function")
    public void SelectADate() {
        driver = super.getDriver();
        driver.get("http://jqueryui.com/datepicker/");
        //datePickerLocator = new DatePickerLocator(driver);
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));
        WebElement datePickerLocator = driver.findElement(By.id("datepicker"));
        datePickerLocator.sendKeys("08/15/2018");
        datePickerLocator.sendKeys(Keys.ENTER);
        System.out.println("the selected date is : " + datePickerLocator.getText());
    }

    @Test(description = "To verify the false condition")
    public void assertFalse() {
        Assert.assertFalse(false);
    }


}
