package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlPage {
	WebDriver driver;

	public DynamicControlPage(WebDriver webDriver) throws Exception {
		this.driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "h4")
	public WebElement lblheader;

	@FindBy(id = "btn")
	public WebElement btnAddRemove;

	@FindBy(id = "message")
	public WebElement lblMessage;

	@FindBy(id = "checkbox")
	public List<WebElement> chkCheckbox;

	public void removetheCheckbox() throws Exception {
		btnAddRemove.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(lblMessage, "It's gone!"));

	}

	public boolean IsCheckboxPresent() {
		return chkCheckbox.size() > 0;
	}

	public String getMessagefortheButtonClick() {
		return lblMessage.getText();
	}

	public void addTheCheckboxagain() throws Exception {
		btnAddRemove.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(lblMessage, "It's back!"));
	}
}
