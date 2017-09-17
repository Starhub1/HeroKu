package TestCase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import iniitialize.Init;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenu extends Init {

    WebDriver dr;
    WebDriverWait wait;
    WebElement src, dst;
    Actions a;
    Init init = new Init();

    @Test(description = "This is a sample test to verify the context menu:")
    public void VerifyContextMenu() {
        dr = super.getDriver();
        dr.get("http://the-internet.herokuapp.com/context_menu");
        System.out.println("This is a sample test");
        WebElement el = dr.findElement(By.id("hot-spot"));
        el.click();
        Actions a = new Actions(dr);
        a.contextClick(el).perform();
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ENTER).perform();
        Alert al = dr.switchTo().alert();
        System.out.println(al.getText());
        Assert.assertTrue(al.getText().contains("You selected a context menu"));
        init.tearDown();
    }



}
