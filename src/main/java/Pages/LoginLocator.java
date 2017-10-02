package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocator {
	
	public LoginLocator(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="h2")
	public static WebElement header;
	
	@FindBy(id="username")
	public static WebElement txtUsername;
	
	@FindBy(id="password")
	public static WebElement txtPassword;
	
	@FindBy(css="button")
	public static WebElement btnLogin;
	
	@FindBy(id="flash")
	public static WebElement txtInvalidMsg;
	
	@FindBy(id="flash")
	public static WebElement txtValidMsg;
	
	
}
