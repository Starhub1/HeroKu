package TestCase;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import iniitialize.Init;
import iniitialize.Util;


public class CheckBoxes extends Init {
    
    WebDriverWait wait;
    WebElement src, dst;
    Actions a;
    WebDriver dr;
    @Test
    public void VerifyCheckBoxLabel() {
    	dr=super.getDriver();
    	dr.get("http://the-internet.herokuapp.com/checkboxes");
        System.out.println("This is a sample test");
        String labels = dr.findElement(By.id("checkboxes")).getText();
        String labelArr[] = labels.split("\n");
        for (String lbl : labelArr) {
            AssertJUnit.assertTrue(lbl.contains("checkbox"));
        }
    }
   
}


