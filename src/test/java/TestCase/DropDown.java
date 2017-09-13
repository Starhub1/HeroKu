package TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import iniitialize.Init;

import java.util.List;

public class DropDown extends Init {
    WebDriver driver;
    WebDriverWait wait;
    Select dropdown;
    List<WebElement> options;
    Init init = new Init();
    
    @BeforeClass
    public void setup() {
    	driver = super.getDriver();
    	driver.get("http://the-internet.herokuapp.com/dropdown");
        wait = new WebDriverWait(driver, 30);
        dropdown = new Select(driver.findElement(By.id("dropdown")));
    }

    @Test
    public void VerifyDropDownValues() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("dropdown")));
        options = dropdown.getOptions();
        for (WebElement o : options)
            System.out.println(o.getText());

    }

    @Test
    public void SelectAvalue() {
        dropdown.selectByValue("1");
        String s = dropdown.getFirstSelectedOption().toString();
        System.out.println("This is the select value " + s);
    }


}
