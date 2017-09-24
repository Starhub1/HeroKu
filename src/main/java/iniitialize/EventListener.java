package iniitialize;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Field;

public class EventListener extends AbstractWebDriverEventListener {
    ExtentTest test;
    ExtentReports report = Init.report;
    private WebDriver webDriver;


    @BeforeMethod
    public void beforemethod(ITestResult res) {
        Object currentClass = res.getInstance();
        test = ((Init) currentClass).getLogger();
    }
    public void beforeAlertAccept(WebDriver driver) {

    }


    public void afterAlertAccept(WebDriver driver) {

    }

    public void afterAlertDismiss(WebDriver driver) {

    }


    public void beforeAlertDismiss(WebDriver driver) {

    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: '" + url + "'");
        test.log(LogStatus.PASS,"Before Navigation","Navigation to " + url);
    }

    public void afterNavigateTo(String url, WebDriver driver) {
      System.out.println("Navigated to:'" + url + "'");
      test.log(LogStatus.PASS,"After Navigation","navigation successful");

    }

    public void beforeNavigateBack(WebDriver driver) {

    }

    public void afterNavigateBack(WebDriver driver) {

    }

    public void beforeNavigateForward(WebDriver driver) {

    }


    public void afterNavigateForward(WebDriver driver) {

    }


    public void beforeNavigateRefresh(WebDriver driver) {

    }

    public void afterNavigateRefresh(WebDriver driver) {

    }


    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        /*System.out.printf("Searching for the element %s in the DOM", element.getText() );
        System.out.println("");*/

    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        /*System.out.printf("Successfully searched the element %s in the DOM ",element.getText());
        System.out.println("");*/
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
        test.log(LogStatus.PASS,"Clicking on ","Trying to click on: " + element.getText());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
        test.log(LogStatus.PASS,"Clicked On","Clicked on: " + element.getText());
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.printf("The value of the element %s before changing is : %s" , element.getText(),keysToSend.toString());
        System.out.println("");
        test.log(LogStatus.PASS,"Before Changing the value","The value of the element" + element.getText() + " before changing is : " + keysToSend.toString());

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.printf("The value of the element %s after changing is : %s" , element.getText(),keysToSend.toString());
        System.out.println("");
        test.log(LogStatus.PASS,"After Changing the value","The value of the element" + element.getText() + " after changing is : " + keysToSend.toString());

    }

    public void beforeScript(String script, WebDriver driver) {

    }
    public void afterScript(String script, WebDriver driver) {

    }

    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Error occurred: " + error);
        test.log(LogStatus.FATAL,"Error occured");
    }
}
