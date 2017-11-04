package TestCase;

import static org.testng.Assert.assertEquals;

import com.relevantcodes.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.DragNDropPage;
import Initialize.Init;

import java.util.Date;

public class DragNdrop extends Init {

	@Test()
	public void VerifyDragNDropFunctionality() throws Exception {

		ExtentTest logger = setLogger("Verify Drag and drop functionality");
		logger.setDescription("Thi is test");
		getDriver().get("http://the-internet.herokuapp.com/drag_and_drop");
		DragNDropPage DragNDropPage = new DragNDropPage(getDriver());
		
		logger.log(LogStatus.INFO, "Verif Drag and Drop Functionality");
		DragNDropPage.dragtoDestination();
		Assert.assertEquals(DragNDropPage.getSrcText(), "B");
		Assert.assertEquals(DragNDropPage.getDestText(), "A");
		
		logger.log(LogStatus.PASS, "Successfuly drag the element to the destination.");
	}
	
	@Test()
	public void verifyheaderoftheDragNDropPage() throws Exception {
		ExtentTest logger = setLogger("Verify header of the Drag and Drop Page");
		logger.setDescription("another test");
		logger.setStartedTime(new Date());
		getDriver().get("http://the-internet.herokuapp.com/drag_and_drop");
		DragNDropPage DragNDropPage = new DragNDropPage(getDriver());
		
		logger.log(LogStatus.INFO, "Verify Header of the Page");
		String header = DragNDropPage.getHeader();
		assertEquals(header, "Drag and Drop");
		logger.log(LogStatus.PASS, "Header of the Page is "+ header);
		
	}


}
