package TestCase;

import static org.testng.Assert.assertEquals;

import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.MousehoverPage;
import Initialize.Init;

public class MouseHover extends Init {

	@Test
	public void verifyMouseHoverFunctionality() throws Exception {

		ExtentTest logger = setLogger("Verify Mouse Hover Functionality ");

		getDriver().get("http://the-internet.herokuapp.com/hovers");
		MousehoverPage mouseHoverOnUserImage = new MousehoverPage(getDriver());

		logger.log(LogStatus.INFO,"Verify On Mouse Hover of User 1");
		mouseHoverOnUserImage.mouseHoverOnUserImage(1);
		assertEquals(mouseHoverOnUserImage.getUserNameonMouseHover(1),"name: user1");
		assertEquals(mouseHoverOnUserImage.getViewProfileLinktext(1),"View profile");
		logger.log(LogStatus.PASS, "On Mouse Hover of user1 the user name of the user is " + mouseHoverOnUserImage.getUserNameonMouseHover(1));
		logger.log(LogStatus.PASS, "On Mouse Hover of user1 the Profile link text of the user is " + mouseHoverOnUserImage.getViewProfileLinktext(1));

	}

	@Test()
	public void verifyViewProfileLinkFunctionality() throws Exception {

		ExtentTest logger = setLogger("Verify ViewProfile Link Functionality");

		getDriver().get("http://the-internet.herokuapp.com/hovers");
		MousehoverPage hoverPg = new MousehoverPage(getDriver());

		logger.log(LogStatus.INFO,"Verify Clicking View Profile Link of the User 2");
		hoverPg.clickOnViewProfileLinkoftheUser(2);
		String header = hoverPg.getheaderoftheProfilePage();
		assertEquals(header, "Not Found");
		logger.log(LogStatus.PASS, "The Header of the Page is " +header);

		logger.log(LogStatus.INFO,"Verify Clicking View Profile Link of the User 3");
		hoverPg.clickOnViewProfileLinkoftheUser(3);
		header = hoverPg.getheaderoftheProfilePage();
		assertEquals(header, "Not Found");
		logger.log(LogStatus.PASS, "The Header of the Page is " +header);

	}

	}

