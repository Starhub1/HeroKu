package TestCase;

import Initialize.ExcelReader;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.awt.*;
import java.io.File;

public class test {

    public static void main(String[] args) throws Exception {
       /* System.setProperty("webdriver.chrome.driver", "src/test/Resource/chromedriver_win32/chromedriver.exe");
        WebDriver dr = new ChromeDriver();
        dr.get("http://the-internet.herokuapp.com/dynamic_controls");
        JavascriptExecutor jse = (JavascriptExecutor) dr;
        WebElement element = dr.findElement(By.id("btn"));
        String text = (String) jse.executeScript("return arguments[0].innerText || arguments[0].textContent || arguments[0].value",element);
        System.out.println(text);*/
        ExcelReader.read("test.xlsx");

    }

}
