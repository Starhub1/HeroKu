package TestCase;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import iniitialize.Init;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu extends Init {

    WebDriver dr;
    ExtentTest logger;

    @Test(description = "This is a sample test to verify the context menu:",testName = "contextMenu Verification")
    public void VerifyContextMenu() {
        logger= super.getLogger();
        dr = super.getDriver();
        logger.log(LogStatus.INFO,"Verify Context Menu");
        logger.log(LogStatus.PASS,"Browser Started");
        dr.get("http://the-internet.herokuapp.com/context_menu");
        System.out.println("This is a sample test");
        WebElement el = dr.findElement(By.id("hot-spot"));
        logger.log(LogStatus.PASS,"search the element to click");
        el.click();
        Actions a = new Actions(dr);
        a.contextClick(el).perform();
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ENTER).perform();
        logger.log(LogStatus.PASS,"Perform context click");
        Alert al = dr.switchTo().alert();
        System.out.println(al.getText());
        Assert.assertTrue(al.getText().contains("You selected a context menu"));
    }



}
