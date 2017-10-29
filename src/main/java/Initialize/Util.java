package Initialize;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util {

	private static String filePath;

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		Util.filePath = filePath + "Execution Report " + Util.getCurrentDateTime() + "/index.html";
	}

	public static void main(String args[]) {
		String filepath = "./test-results/" + "Execution Report " + System.nanoTime() + "/index.html";
		System.out.println(filepath.substring(0, filepath.length() - 10));
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

		/*
		 * File file = new File(
		 * "C:\\Users\\nasir\\IdeaProjects\\HerokuApp\\test-results\\"+"Execution
		 * Report "+init.getReportName()+"\\screenshots\\"); if
		 * (!file.exists()){ file.mkdir(); }
		 */
		Path path = Paths.get(filePath).getParent();
		path = path.resolve("Screenhshots");

		if (!path.toFile().exists()) {
			try {
				FileUtils.forceMkdir(path.toFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		path = path.resolve(methodName + "/" + methodName + getCurrentDateTime() + ".png");

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile, path.toFile());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return path.toString();
	}

	public static void SelectByVal(String val, WebElement ele, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String script = "var ofs = 0;var el = arguments[0];var winInterval = setInterval(function(){el.style.background = 'rgba(255,230,20,'+Math.abs(Math.sin(ofs))+')'; ofs += 0.15;	}, 1);		setTimeout(function(){el.style.background = 'none';clearInterval(winInterval)},300)";
		jse.executeScript(script, ele);
		Select select = new Select(ele);
		select.selectByValue(val);
	}
}