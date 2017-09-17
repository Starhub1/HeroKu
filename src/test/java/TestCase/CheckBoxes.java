package TestCase;

import iniitialize.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class CheckBoxes extends Init {

    WebDriverWait wait;
    WebElement src, dst;
    Actions a;
    WebDriver dr;

    @Test(description = "To verify the Checkboxes values")
    public void VerifyCheckBoxLabel() {
        dr = super.getDriver();
        dr.get("http://the-internet.herokuapp.com/checkboxes");
        System.out.println("This is a sample test");
        String labels = dr.findElement(By.id("checkboxes")).getText();
        String labelArr[] = labels.split("\n");
        for (String lbl : labelArr) {
            AssertJUnit.assertTrue(lbl.contains("checkbox"));
        }
    }

}


