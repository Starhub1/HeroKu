package TestCase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.DragNDropPage;
import Initialize.Init;

public class DragNdrop extends Init {

	@Test(expectedExceptions = {})
	public void VerifyDragNDropFunctionality() throws Exception {
		
		logger = report.startTest("Verify Drag and drop functionality");
		test.set(logger);
		
		getDriver().get("http://the-internet.herokuapp.com/drag_and_drop");
		DragNDropPage DragNDropPage = new DragNDropPage();
		
		logger.log(LogStatus.INFO, "Verif Drag and Drop Functionality");
		DragNDropPage.dragtoDestination();
		Assert.assertEquals(DragNDropPage.getSrcText(), "B");
		Assert.assertEquals(DragNDropPage.getDestText(), "A");
		
		logger.log(LogStatus.PASS, "Successfuly drag the element to the destination.");
	}
	
	@Test()
	public void verifyheaderoftheDragNDropPage() throws Exception {
		logger = report.startTest("Verify header of the Drag and Drop Page");
		test.set(logger);
		
		getDriver().get("http://the-internet.herokuapp.com/drag_and_drop");
		DragNDropPage DragNDropPage = new DragNDropPage();
		
		logger.log(LogStatus.INFO, "Verify Header of the Page");
		String header = DragNDropPage.getHeader();
		assertEquals(header, "Drag and Drop");
		logger.log(LogStatus.PASS, "Header of the Page is "+ header);
		
	}


}
