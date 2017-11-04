package TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.ContextMenuPage;
import Initialize.Init;

public class ContextMenu extends Init {

	@Test()
	public void VerifyContextMenuFunctionality() throws Exception {
		ExtentTest logger = setLogger("Verify ContextMenu Functionality").assignAuthor("Mohammed Nasir").assignCategory("Category Regression");

		getDriver().get("http://the-internet.herokuapp.com/context_menu");
		ContextMenuPage ContextMenuPage =  new ContextMenuPage(getDriver());
		
		logger.log(LogStatus.INFO, "Verify Right Click");
		ContextMenuPage.performRightClick();
		logger.log(LogStatus.PASS, "Right Click performed successfuly");
		
		logger.log(LogStatus.INFO, "Switch to Alert");
		assertTrue(ContextMenuPage.IsAlertPresent());
		ContextMenuPage.switchToAlert();
		logger.log(LogStatus.PASS, "Successfuly Switched to Alert");
		
		logger.log(LogStatus.INFO, "Verify the text on the Alert");
		assertEquals("You selected a context menu", ContextMenuPage.getAlertText());
		logger.log(LogStatus.PASS, "Text in the Alert is : " + ContextMenuPage.getAlertText());
		
		logger.log(LogStatus.INFO, "Verify Clicking Ok on the Alert");
		ContextMenuPage.AcceptAlert();
		assertFalse(ContextMenuPage.IsAlertPresent());
		logger.log(LogStatus.PASS, "Alert Closed successfully");
	}
	
	

	@Test()
	public void verifyheaderoftheContextMenuPage() throws Exception {
		ExtentTest logger = setLogger("Verigy the header of the context Menu page.").assignAuthor("Mohammed Nasir").assignCategory("Category Regression");

		getDriver().get("http://the-internet.herokuapp.com/context_menu");
		ContextMenuPage ContextMenuPage =  new ContextMenuPage(getDriver());
		
		logger.log(LogStatus.INFO, "Verify Header of the Page");
		String header = ContextMenuPage.getheaderofthePage();
		assertEquals(header, "Context Menu");
		logger.log(LogStatus.PASS, "Header of the Page is "+ header);
		
	}

}
