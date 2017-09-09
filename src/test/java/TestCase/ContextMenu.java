package TestCase;
import Iniitialize.Init;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu {

    WebDriver dr;
    WebDriverWait wait;
    WebElement src, dst;
    Actions a;
    Init init = new Init(dr);

    @Test
    public void VerifyContextMenu() {
        dr = init.setup("http://the-internet.herokuapp.com/context_menu", "edge");

        System.out.println("This is a sample test");
        WebElement el = dr.findElement(By.id("hot-spot"));
        Actions a = new Actions(dr);
        a.contextClick(el).perform();
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ARROW_DOWN);
        a.contextClick(el).sendKeys(Keys.ENTER).perform();
        Alert al = dr.switchTo().alert();
        System.out.println(al.getText());
        Assert.assertTrue(al.getText().contains("You selected a context menu"));
        init.tearDown();
    }

}
