package TestCase;
import Iniitialize.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown {
    WebDriver driver;
    WebDriverWait wait;
    Select dropdown;
    List<WebElement> options;
    Init init = new Init(driver);
    @BeforeClass
    public void setup() {
        driver = init.setup("http://the-internet.herokuapp.com/dropdown", "chrome");
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


    @AfterClass
    public void teardown() {
        init.tearDown();
    }
}
