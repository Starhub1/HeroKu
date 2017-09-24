package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DynamicControlLocator {

    public DynamicControlLocator(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "h4")
    public static WebElement lblheader;

    @FindBy(id = "btn")
    public static WebElement btnAddRemove;

    @FindBy(id="message")
    public static WebElement lblMessage;

    @FindBy(id="checkbox")
    public static List <WebElement> chkCheckbox;



}
