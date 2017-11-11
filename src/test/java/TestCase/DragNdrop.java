package TestCase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import Pages.DragNDropPage;
import Initialize.Init;

import java.util.Date;

public class DragNdrop extends Init {

	@Test()
	public void VerifyDragNDropFunctionality() throws Exception {

		ExtentTest logger = setLogger("Verify Drag and drop functionality");
		getDriver().get("http://the-internet.herokuapp.com/drag_and_drop");
		DragNDropPage DragNDropPage = new DragNDropPage(getDriver());
		
		logger.log(Status.INFO, "Verif Drag and Drop Functionality");
		DragNDropPage.dragtoDestination();
		Assert.assertEquals(DragNDropPage.getSrcText(), "B");
		Assert.assertEquals(DragNDropPage.getDestText(), "A");
		
		logger.log(Status.PASS, "Successfuly drag the element to the destination.");
	}
	
	@Test()
	public void verifyheaderoftheDragNDropPage() throws Exception {
		ExtentTest logger = setLogger("Verify header of the Drag and Drop Page");
		getDriver().get("http://the-internet.herokuapp.com/drag_and_drop");
		DragNDropPage DragNDropPage = new DragNDropPage(getDriver());
		
		logger.log(Status.INFO, "Verify Header of the Page");
		String header = DragNDropPage.getHeader();
		assertEquals(header, "Drag and Drop");
		logger.log(Status.PASS, "Header of the Page is "+ header);
		
	}


}
