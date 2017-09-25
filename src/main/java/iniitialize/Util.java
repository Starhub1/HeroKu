package iniitialize;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Util {
	private static String filePath;

	public static void main(String args[]) {
		System.out.println("The current time in millis: " + System.currentTimeMillis());
		System.out.println("THe current time in nanos" + System.nanoTime());
		Date date = new Date();
		System.out.println("The current date is " + date.toString());
		Date afterdate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
		System.out.println("The future date is " + afterdate);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM.yyyy hh-mm-ss");
		System.out.println(sdf.format(afterdate));
		System.out.println(sdf.format(date));
	}

	public static String getCurrentDateTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM.yyyy hh-mm-ss");
		return sdf.format(date);

	}

	public static String takeScreenShot(String methodName, WebDriver driver) {
		File file = new File();
		filePath = Init.filepath.substring(0, Init.filepath.length() - 11);
		filePath = "./Screenshots/" + methodName + System.currentTimeMillis() + ".png";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile, new File(filePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
}