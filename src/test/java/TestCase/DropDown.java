package TestCase;
import iniitialize.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown extends Init {
    WebDriver driver = super.getDriver();

   Select dropdown;
   List<WebElement> options;

    @Test(description = "Verify the drop down values")
    public void VerifyDropDownValues() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        wait = new WebDriverWait(driver, 30);
        dropdown = new Select(driver.findElement(By.id("dropdown")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("dropdown")));
        options = dropdown.getOptions();
        for (WebElement o : options)
            System.out.println(o.getText());

    }

    @Test(description = "verify selected value")
    public void SelectAvalue() {
        wait = new WebDriverWait(driver, 30);
        dropdown = new Select(driver.findElement(By.id("dropdown")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("dropdown")));
        dropdown.selectByValue("1");
        String s = dropdown.getFirstSelectedOption().toString();
        System.out.println("This is the select value " + s);
    }


}