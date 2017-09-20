package TestCase;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import iniitialize.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown extends Init {

   WebDriver driver;
   Select dropdown;
   List<WebElement> options;
   public ExtentTest logger;


    @Test()
    public void VerifyDropDownValues() {
        logger= super.getLogger();
        driver = super.getDriver();
        logger.log(LogStatus.INFO,"Verify the drop down values ");
        logger.log(LogStatus.PASS,"Browser Started");
        driver.get("http://the-internet.herokuapp.com/dropdown");
        logger.log(LogStatus.PASS,"Successuly navigated to the URL:");
        dropdown = new Select(driver.findElement(By.id("dropdown")));
        logger.log(LogStatus.PASS,"Search element suceess");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("dropdown")));
        options = dropdown.getOptions();
        for (WebElement o : options)
            System.out.println(o.getText());

    }

    @Test(dependsOnMethods = {"VerifyDropDownValues"})
    public void SelectAvalue() {
        logger.log(LogStatus.INFO,"Select the vaule 1 from the drop down");
        dropdown.selectByValue("1");
        String s = dropdown.getFirstSelectedOption().toString();
        System.out.println("This is the select value " + s);
        logger.log(LogStatus.PASS,"PASSED");
    }


}