package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialize.Init;

public class DragNDropPage {

	public DragNDropPage() throws Exception {
		PageFactory.initElements(Init.getDriver(), this);
	}

	@FindBy(css = "h3")
	private static WebElement header;

	@FindBy(id = "column-a")
	private static WebElement src;

	@FindBy(id = "column-b")
	private static WebElement dest;

	@FindBy(css = "#column-a>header")
	private static WebElement srctext;

	@FindBy(css = "#column-b>header")
	private static WebElement destext;

	public void dragtoDestination() throws Exception {
		new WebDriverWait(Init.getDriver(), 10).until(ExpectedConditions.visibilityOf(src));
		Actions action = new Actions(Init.getDriver());
		action.clickAndHold(src).moveToElement(dest).release(src).perform();

	}

	public String getSrcText() {
		return srctext.getText();
	}

	public String getDestText() {
		return destext.getText();
	}
	
	public String getHeader() {
		return header.getText();
	}

}
