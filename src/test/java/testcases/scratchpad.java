package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import init.Init;

public class scratchpad extends Init{


public void test() {
	getDriver().get("https://www.w3schools.com/htmL/html5_draganddrop.asp");
	WebElement src = getDriver().findElement(By.id("drag1"));
	WebElement dest = getDriver().findElement(By.cssSelector("div[id='div2']"));
	final Actions action = new Actions(getDriver());
	action.clickAndHold(src)
	.moveByOffset(-1, -1) // To fix issue with drag and drop in Chrome V61.0.3163.79
	.moveToElement(dest, dest.getLocation().getX()+dest.getSize().getWidth()/2, dest.getLocation().getY()+dest.getSize().getHeight()/2)
	.release(dest)
	.build()
	.perform();
}	
}
