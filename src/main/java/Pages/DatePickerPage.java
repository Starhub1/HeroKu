package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Initialize.Init;

public class DatePickerPage {
	
    @FindBy(id = "datepicke")
    private   WebElement datepicker;
    
    @FindBy(className = "entry-title")
    private  WebElement Pgheader;
    EventFiringWebDriver driver;
    public DatePickerPage(EventFiringWebDriver driver) throws Exception {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    public void  selectAdateintheDateFieled(String date) throws Exception {
    	new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));
    	datepicker.sendKeys(date);
		datepicker.sendKeys(Keys.ENTER);
	
    }
    
    public String getPageheader() {
    	System.out.println(Pgheader.getText());
    	return Pgheader.getText();
    }
    
}
