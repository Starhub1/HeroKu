package Pages;

import Initialize.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DynamicControlPage {
    EventFiringWebDriver driver;
    public DynamicControlPage(EventFiringWebDriver driver) throws Exception {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "h4")
    public  WebElement lblheader;

    @FindBy(id = "btn")
    public  WebElement btnAddRemove;

    @FindBy(id="message")
    public  WebElement lblMessage;

    @FindBy(id="checkbox")
    public  List <WebElement> chkCheckbox;


    public void removetheCheckbox() throws Exception {
        btnAddRemove.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.textToBePresentInElement(lblMessage, "It's gone!"));

    }

    public boolean IsCheckboxPresent () {
        return chkCheckbox.size()>0;
    }

    public String getMessagefortheButtonClick() {
        return lblMessage.getText();
    }

    public void addTheCheckboxagain() throws Exception {
        btnAddRemove.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.textToBePresentInElement(lblMessage, "It's back!"));
    }
}
