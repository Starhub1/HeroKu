package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MousehoverLocator {

    public MousehoverLocator(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='figure']/img")
    public List<WebElement> imguser;


    @FindBy(xpath = "//div[@class='figcaption']/h5")
    public List<WebElement> userName;


    @FindBy(xpath = "//div[@class='figcaption']/a")
    public List<WebElement> lnkViewProfile;

    @FindBy(css = "h1")
    public WebElement txtHeader;

}
