package Pages;

import Initialize.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DynamicControlPage {

    public DynamicControlPage() throws Exception {
        PageFactory.initElements(Init.getDriver(),this);
    }

    @FindBy(css = "h4")
    public static WebElement lblheader;

    @FindBy(id = "btn")
    public static WebElement btnAddRemove;

    @FindBy(id="message")
    public static WebElement lblMessage;

    @FindBy(id="checkbox")
    public static List <WebElement> chkCheckbox;


    public void removetheCheckbox() throws Exception {
        btnAddRemove.click();
        new WebDriverWait(Init.getDriver(),10).until(ExpectedConditions.textToBePresentInElement(lblMessage, "It's gone!"));

    }

    public boolean IsCheckboxPresent () {
        return chkCheckbox.size()>0;
    }

    public String getMessagefortheButtonClick() {
        return lblMessage.getText();
    }

    public void addTheCheckboxagain() throws Exception {
        btnAddRemove.click();
        new WebDriverWait(Init.getDriver(),10).until(ExpectedConditions.textToBePresentInElement(lblMessage, "It's back!"));
    }
}
