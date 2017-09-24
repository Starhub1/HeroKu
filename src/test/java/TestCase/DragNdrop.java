package TestCase;

import com.relevantcodes.extentreports.LogStatus;
import iniitialize.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragNdrop extends Init {
    WebElement src, dst;
    Actions a;

    @Test(expectedExceptions = {})
    public void DragDropVerify() {
        logger =report.startTest("Verify Drag and drop functionality");
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-b")));
        src = driver.findElement(By.id("column-a"));
        System.out.println(src.getText());
        dst = driver.findElement(By.id("column-b"));
        System.out.println(dst.getText());
        logger.log(LogStatus.PASS,"Get the Text",dst.getText());
        a = new Actions(driver);
        // a.dragAndDrop(src,dst).build().perform();
        a.clickAndHold(src).moveToElement(dst).release(src).build().perform();
        String actualText = driver.findElement(By.cssSelector("#column-a>header")).getText();
        Assert.assertEquals(actualText, "A");
    }
}
