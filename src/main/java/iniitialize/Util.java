package iniitialize;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Util {
    private static String filePath;

    public static String takeScreenShot(String methodName, WebDriver driver) {
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