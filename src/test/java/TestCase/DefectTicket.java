package TestCase;

import static Pages.DefectPageLocator.btnLogin;
import static Pages.DefectPageLocator.chkAttachScreenshot;
import static Pages.DefectPageLocator.pgHeader;
import static Pages.DefectPageLocator.pgLoginUnsuccess;
import static Pages.DefectPageLocator.selComponent;
import static Pages.DefectPageLocator.selDefectType;
import static Pages.DefectPageLocator.selFoundInBuild;
import static Pages.DefectPageLocator.selOwner;
import static Pages.DefectPageLocator.selSubSystem;
import static Pages.DefectPageLocator.selTeam;
import static Pages.DefectPageLocator.selTestType;
import static Pages.DefectPageLocator.selType;
import static Pages.DefectPageLocator.txtDescription;
import static Pages.DefectPageLocator.txtParent;
import static Pages.DefectPageLocator.txtPassword;
import static Pages.DefectPageLocator.txtSummary;
import static Pages.DefectPageLocator.txtTestcase;
import static Pages.DefectPageLocator.txtUserID;
import static org.testng.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.DefectPageLocator;
import iniitialize.Init;
import iniitialize.Util;

public class DefectTicket extends Init {
	Properties input;
	DefectPageLocator defectPg;
	Select sel;
	String encoded;

	@Test
	public void raiseDefectTicket() {
		input = new Properties();
		try {
			input.load(new BufferedInputStream(new FileInputStream("Input.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		defectPg = new DefectPageLocator(driver);
		logger = report.startTest("Rasing a Defect");
		driver.get(input.getProperty("URL"));
		if (pgLoginUnsuccess.isDisplayed()) {
			pgLoginUnsuccess.click();
			txtUserID.sendKeys(input.getProperty("userid"));

			String password = input.getProperty("password");

			if (!password.startsWith("ENCO")) {
				password = "ENCO" + Base64.getEncoder().encodeToString(password.getBytes());
				input.setProperty("password", password);
				try {
					input.store(new FileOutputStream("Input.properties"), "encrypted the password");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			password = password.substring(4);
			byte[] passwordInbyte = Base64.getDecoder().decode(password);
			try {
				txtPassword.sendKeys(new String(passwordInbyte, "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			btnLogin.click();
		}
		logger.log(LogStatus.PASS, "Navigate to the URL: http://blrtrac.corp.tangoe.com/newticket");
		wait.until(ExpectedConditions.visibilityOf(pgHeader));
		assertEquals(pgHeader.getText(), "Create New Ticket");
		String summary = input.getProperty("summary");
		txtSummary.sendKeys(summary);
		String description = input.getProperty("description");
		txtDescription.sendKeys(description);
		Util.SelectByVal(input.getProperty("selType"), selType, driver);
		Util.SelectByVal(input.getProperty("selDefectType"), selDefectType, driver);
		Util.SelectByVal(input.getProperty("selComponent"), selComponent, driver);
		Util.SelectByVal(input.getProperty("selComponent"), selComponent, driver);
		Util.SelectByVal(input.getProperty("selSubSystem"), selSubSystem, driver);
		Util.SelectByVal(input.getProperty("selOwner"), selOwner, driver);
		Util.SelectByVal(input.getProperty("selTeam"), selTeam, driver);
		txtParent.sendKeys(input.getProperty("txtParent"));
		Util.SelectByVal(input.getProperty("selFoundInBuild"), selFoundInBuild, driver);
		txtTestcase.sendKeys(input.getProperty("txtTestcase"));
		Util.SelectByVal(input.getProperty("selTestType"), selTestType, driver);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", chkAttachScreenshot);

		chkAttachScreenshot.click();

	}
}
