package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CheckboxPage {
	public CheckboxPage(EventFiringWebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "h3")
	private  WebElement header;

	@FindBy(xpath = "//input[@type='checkbox']")
	private  List<WebElement> checkboxes;

	public  String getTitle(EventFiringWebDriver driver) {
		return driver.getTitle();
	}

	public String getheader() {
		return header.getText();
	}

	public List<WebElement> getCheckboxes() {
		return checkboxes;
	}

	public void selectCheckbox(int index) {
		if (!isSelected(index))
			checkboxes.get(index).click();
	}

	public void deSelectCheckbox(int index) {
		if (isSelected(index))
			checkboxes.get(index).click();
	}

	public boolean isSelected(int index) {
		return checkboxes.toArray(new WebElement[checkboxes.size()])[index].isSelected();
	}
	
}
