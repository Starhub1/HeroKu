package testcases;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.JsonObject;

public class test {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "src/test/Resource/chromedriver_win32/chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("https://99namesofallah.name/");
		WebDriverWait wait = new WebDriverWait(dr, 10);
		wait.until(ExpectedConditions.titleContains("99 Names of Allah "));

		List<WebElement> id = dr.findElements(By.xpath("//table/tbody/tr/td[1]"));
		List<WebElement> arabicName = dr.findElements(By.xpath("//table/tbody/tr/td[2]"));
		List<WebElement> englishName = dr.findElements(By.xpath("//table/tbody/tr/td[3]"));
		List<WebElement> meaning = dr.findElements(By.xpath("//table/tbody/tr/td[4]"));
		List<WebElement> detail = dr.findElements(By.xpath("//table/tbody/tr/td[5]"));

		List<String> txtid = new ArrayList<String>();
		List<String> txtarabicName = new ArrayList<String>();
		List<String> txtenglishName = new ArrayList<String>();
		List<String> txtmeaning = new ArrayList<String>();
		List<String> txtdetail = new ArrayList<String>();

		for (WebElement e : id) {
			txtid.add(e.getText());
		}
		// txtid.remove(99);
		for (WebElement e : arabicName) {
			txtarabicName.add(e.getText());
		}

		for (WebElement e : englishName) {
			txtenglishName.add(e.getText());
		}

		for (WebElement e : meaning) {
			txtmeaning.add(e.getText());
		}

		for (WebElement e : detail) {
			txtdetail.add(e.getText());
		}
		FileUtils.touch(new File("names.txt"));
		BufferedWriter wr = Files.newBufferedWriter(Paths.get("names.txt"), StandardCharsets.UTF_8,
				StandardOpenOption.WRITE);
		JsonObject obj[] = new JsonObject[99];
		for (int i = 0; i < obj.length; i++) {
			obj[i] = new JsonObject();
			obj[i].addProperty("id", txtid.get(i));
			obj[i].addProperty("arabicName", txtarabicName.get(i));
			obj[i].addProperty("englishName", txtenglishName.get(i));
			obj[i].addProperty("meaning", txtmeaning.get(i));
			obj[i].addProperty("detail", txtdetail.get(i));
			wr.write(obj[i].toString());
			wr.write(",");
			wr.newLine();
			System.out.println(obj[i]);

		}
		wr.flush();
		dr.quit();
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/test/Resource/chromedriver_win32/chromedriver.exe"); WebDriver dr = new
		 * ChromeDriver(); dr.get("http://the-internet.herokuapp.com/dynamic_controls");
		 * JavascriptExecutor jse = (JavascriptExecutor) dr; WebElement element =
		 * dr.findElement(By.id("btn")); String text = (String) jse.
		 * executeScript("return arguments[0].innerText || arguments[0].textContent || arguments[0].value"
		 * ,element); System.out.println(text); ExcelReader.read("test.xlsx");
		 */

	}

}
