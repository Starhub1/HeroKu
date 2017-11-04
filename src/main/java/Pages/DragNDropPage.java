package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialize.Init;

public class DragNDropPage {
	EventFiringWebDriver driver;
	public DragNDropPage(EventFiringWebDriver driver) throws Exception {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "h3")
	private  WebElement header;

	@FindBy(id = "column-a")
	private  WebElement src;

	@FindBy(id = "column-b")
	private  WebElement dest;

	@FindBy(css = "#column-a>header")
	private  WebElement srctext;

	@FindBy(css = "#column-b>header")
	private  WebElement destext;

	public void dragtoDestination() throws Exception {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(src));
		Actions action = new Actions(driver);
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
