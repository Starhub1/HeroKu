package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MousehoverPage {
	WebDriver driver;

	public MousehoverPage(WebDriver webDriver) throws Exception {
		this.driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(xpath = "//div[@class='figure']/img")
	private List<WebElement> imguser;

	@FindBy(xpath = "//div[@class='figcaption']/h5")
	private List<WebElement> userName;

	@FindBy(xpath = "//div[@class='figcaption']/a")
	private List<WebElement> lnkViewProfile;

	@FindBy(css = "h1")
	private WebElement txtHeader;

	public void mouseHoverOnUserImage(int index) throws Exception {
		Actions a = new Actions(driver);
		a.moveToElement(imguser.get(index - 1)).build().perform();
	}

	public String getUserNameonMouseHover(int index) {
		return userName.get(index - 1).getText();
	}

	public String getViewProfileLinktext(int index) {
		return lnkViewProfile.get(index - 1).getText();
	}

	public void clickOnViewProfileLinkoftheUser(int index) throws Exception {
		mouseHoverOnUserImage(index);
		lnkViewProfile.get(index - 1).click();
	}

	public String getheaderoftheProfilePage() throws Exception {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(txtHeader));
		String header = txtHeader.getText();
		driver.navigate().back();
		return header;
	}

}
