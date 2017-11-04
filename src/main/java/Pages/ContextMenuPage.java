package Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialize.Init;

public class ContextMenuPage {
	EventFiringWebDriver driver;

	public ContextMenuPage(EventFiringWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	Actions action;
	@FindBy(id = "hot-spot")
	private  WebElement ctxBox;

	@FindBy(css = "h3")
	private WebElement header;

	public String getHeader() {
		return header.getText();
	}

	public void performRightClick() throws Exception {
		action = new Actions(driver);
		action.contextClick(ctxBox).perform();
		action.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ENTER).perform();
		

	}

	public void switchToAlert() throws Exception {
		new WebDriverWait(driver, 5).
		until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
	}

	public String getAlertText() throws Exception {
		return driver.switchTo().alert().getText();
	}

	public void AcceptAlert() throws Exception {
		driver.switchTo().alert().accept();
	}

	public boolean IsAlertPresent() throws Exception {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException nl) {
			return false;
		}
	}
	
	public String getheaderofthePage() {
		return header.getText();
	}

}
