package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectPageLocator {

	public DefectPageLocator(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "	//a[text()='do so']")
	public static WebElement pgLoginUnsuccess;

	@FindBy(id = "user")
	public static WebElement txtUserID;

	@FindBy(id = "password")
	public static WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	public static WebElement btnLogin;

	@FindBy(xpath = "(//h1)[1]")
	public static WebElement pgHeader;

	@FindBy(id = "field-summary")
	public static WebElement txtSummary;

	@FindBy(id = "field-description")
	public static WebElement txtDescription;

	@FindBy(id = "field-type")
	public static WebElement selType;

	@FindBy(id = "field-defect_type")
	public static WebElement selDefectType;

	@FindBy(id = "field-component")
	public static WebElement selComponent;

	@FindBy(id = "field-sub_system")
	public static WebElement selSubSystem;

	@FindBy(id = "field-parents")
	public static WebElement txtParent;

	@FindBy(id = "field-owner")
	public static WebElement selOwner;

	@FindBy(id = "field-foundinbuild")
	public static WebElement selFoundInBuild;

	@FindBy(id = "field-team")
	public static WebElement selTeam;

	@FindBy(id = "field-test_case_link")
	public static WebElement txtTestcase;

	@FindBy(id = "field-test_type")
	public static WebElement selTestType;

	@FindBy(name = "attachment")
	public static WebElement chkAttachScreenshot;

	;

}
