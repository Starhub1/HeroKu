package TestCase;

import Pages.MousehoverLocator;
import com.relevantcodes.extentreports.LogStatus;
import iniitialize.Init;
import org.openqa.selenium.interactions.Actions;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class MouseHover extends Init{

    Actions a;
    MousehoverLocator hoverPg;

    @Test
    public void verifyMouseHover() {
        logger = report.startTest("Verify Mouse Hover Functionality");
        driver.get("http://the-internet.herokuapp.com/hovers");
        hoverPg = new MousehoverLocator(driver);
        logger.log(LogStatus.PASS,"test","Navigate to the URL: http://the-internet.herokuapp.com/hovers");
        assertEquals(driver.getTitle(),"The Internet");
        logger.log(LogStatus.PASS,"Verify the title of the Page","The title of the page is "+driver.getTitle());
        a = new Actions(driver);
        for (int i=0;i<hoverPg.imguser.size();i++) {
            logger.log(LogStatus.PASS,"USER "+ Integer.sum(i,1));
            a.moveToElement(hoverPg.imguser.get(i)).build().perform();
            assertEquals(hoverPg.userName.get(i).getText(), "name: user"+ Integer.sum(i,1));
            logger.log(LogStatus.PASS, "On Mouse Hover of user1, Verify the username ", "The user name of the user1 is " + hoverPg.userName.get(i).getText());
        }

        logger.log(LogStatus.PASS,"Passed");
    }

    @Test(dependsOnMethods = {"verifyMouseHover"})
    public void verifyViewProfile() {
        logger = report.startTest("Verify ViewProfile Functionality","Test");
        for (int i=0;i<hoverPg.imguser.size();i++) {
            logger.log(LogStatus.PASS,"USER "+ Integer.sum(i,1));
            a.moveToElement(hoverPg.imguser.get(i)).build().perform();
            assertEquals(hoverPg.lnkViewProfile.get(i).getText(), "View profile");
            logger.log(LogStatus.PASS, "On Mouse Hover of user1", "View Profile Hyperlink displayed sucessfully");
            hoverPg.lnkViewProfile.get(i).click();
            assertEquals(hoverPg.txtHeader.getText(), "Not Found");
            logger.log(LogStatus.PASS, "Verify the Header of the Page", "The Header fo the Page is Not Found");
            driver.navigate().back();
            assertEquals(driver.getTitle(), "The Internet");
            logger.log(LogStatus.PASS, "Navigate back to the previous page", "Navigation successful");
        }



    }

}
