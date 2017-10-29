package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialize.Init;

public class DropDownPage {

	public DropDownPage() throws Exception {
		PageFactory.initElements(Init.getDriver(), this);
	}

	@FindBy(id = "dropdown")
	private static WebElement dropdown;

	Select dropdwn;

	public List<String> getAlltheValuesfromtheDropdown() throws Exception {
		List<String> optionsText = new ArrayList<>();
		new WebDriverWait(Init.getDriver(), 10).until(ExpectedConditions.visibilityOf(dropdown));
		dropdwn = new Select(dropdown);
		List<WebElement> options = dropdwn.getOptions();
		for (WebElement o : options) {
			optionsText.add(o.getText());
		}
		return optionsText;
	}
	
	public void SelectAValuefromTheDropDown(int index) throws Exception {
		new WebDriverWait(Init.getDriver(), 10).until(ExpectedConditions.visibilityOf(dropdown));
		dropdwn = new Select(dropdown);
		dropdwn.selectByIndex(index);
	}
	
	public void SelectAValuefromTheDropDown(String value) throws Exception {
		try {
			new WebDriverWait(Init.getDriver(), 10).until(ExpectedConditions.visibilityOf(dropdown));
			dropdwn = new Select(dropdown);
			dropdwn.selectByValue(value);
		} catch (NoSuchElementException e) {
			dropdwn.selectByVisibleText(value);
		}
	}
	
	public String getSelectedValDropDown() throws Exception {
		new WebDriverWait(Init.getDriver(), 10).until(ExpectedConditions.visibilityOf(dropdown));
		dropdwn = new Select(dropdown);
		return dropdwn.getFirstSelectedOption().getText();
	}
	
	

}
