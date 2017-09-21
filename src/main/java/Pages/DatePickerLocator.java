package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickerLocator {
    @FindBy(id = "datepicker")
    public WebElement datepicker;

    public DatePickerLocator(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
