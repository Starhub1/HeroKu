package TestCase;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import iniitialize.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class CheckBoxes extends Init {

    WebDriver dr;
    ExtentTest logger;


    @Test(description = "To verify the Checkboxes values",testName = "Verify Checkbox functionality")
    public void VerifyCheckBoxLabel(){
        logger= super.getLogger();
        dr = super.getDriver();
        logger.log(LogStatus.INFO,"Verify Checkbox functionality");
        logger.log(LogStatus.PASS,"Browser Started");
        dr.get("http://the-internet.herokuapp.com/checkboxes");
        logger.log(LogStatus.PASS,"Navigated to the URL : \"http://the-internet.herokuapp.com/checkboxes\" ");
        String labels = dr.findElement(By.id("checkboxes")).getText();
        logger.log(LogStatus.PASS,"Sucessfully searched the element checkbox");
        String labelArr[] = labels.split("\n");
        for (String lbl : labelArr) {
            AssertJUnit.assertTrue(lbl.contains("checkbox"));
            logger.log(LogStatus.PASS, lbl);
        }
    }

}


