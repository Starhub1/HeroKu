package TestCase;
import Iniitialize.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxes {
    WebDriver dr;
    WebDriverWait wait;
    WebElement src, dst;
    Actions a;
    Init init = new Init(dr);

    @Test
    public void VerifyCheckBoxLabel() {
        dr = init.setup("http://the-internet.herokuapp.com/checkboxes", "chrome");
        System.out.println("This is a sample test");
        String labels = dr.findElement(By.id("checkboxes")).getText();
        String labelArr[] = labels.split("\n");
        for (String lbl : labelArr) {
            Assert.assertTrue(lbl.contains("checkbox"));
        }
        init.tearDown();
    }
}


