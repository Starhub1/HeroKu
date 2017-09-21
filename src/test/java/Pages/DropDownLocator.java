package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownLocator {
	@FindBy(id = "datepicker")
	public WebElement datepicker;
	Select dropdown;

	public DropDownLocator(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
