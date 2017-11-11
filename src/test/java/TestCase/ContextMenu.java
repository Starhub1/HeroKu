package TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import Pages.ContextMenuPage;
import Initialize.Init;

public class ContextMenu extends Init {

	@Test()
	public void VerifyContextMenuFunctionality() throws Exception {
		ExtentTest logger = setLogger("Verify ContextMenu Functionality").assignAuthor("Mohammed Nasir").assignCategory("Category Regression");

		getDriver().get("http://the-internet.herokuapp.com/context_menu");
		ContextMenuPage ContextMenuPage =  new ContextMenuPage(getDriver());
		
		logger.log(Status.INFO, "Verify Right Click");
		ContextMenuPage.performRightClick();
		logger.log(Status.PASS, "Right Click performed successfuly");
		
		logger.log(Status.INFO, "Switch to Alert");
		assertTrue(ContextMenuPage.IsAlertPresent());
		ContextMenuPage.switchToAlert();
		logger.log(Status.PASS, "Successfuly Switched to Alert");
		
		logger.log(Status.INFO, "Verify the text on the Alert");
		assertEquals("You selected a context menu", ContextMenuPage.getAlertText());
		logger.log(Status.PASS, "Text in the Alert is : " + ContextMenuPage.getAlertText());
		
		logger.log(Status.INFO, "Verify Clicking Ok on the Alert");
		ContextMenuPage.AcceptAlert();
		assertFalse(ContextMenuPage.IsAlertPresent());
		logger.log(Status.PASS, "Alert Closed successfully");
	}
	
	

	@Test()
	public void verifyheaderoftheContextMenuPage() throws Exception {
		ExtentTest logger = setLogger("Verigy the header of the context Menu page.").assignAuthor("Mohammed Nasir").assignCategory("Category Regression");

		getDriver().get("http://the-internet.herokuapp.com/context_menu");
		ContextMenuPage ContextMenuPage =  new ContextMenuPage(getDriver());
		
		logger.log(Status.INFO, "Verify Header of the Page");
		String header = ContextMenuPage.getheaderofthePage();
		assertEquals(header, "Context Menu");
		logger.log(Status.PASS, "Header of the Page is "+ header);
		
	}

}
