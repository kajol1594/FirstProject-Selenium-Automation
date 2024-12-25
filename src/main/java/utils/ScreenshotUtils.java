package utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	public static String takeScreenshot(WebDriver driver, String testName) {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timeStamp + ".png";

		File screenshotFolder = new File(System.getProperty("user.dir") + "/screenshots/");
		if (!screenshotFolder.exists()) {
			screenshotFolder.mkdir();
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(screenshotPath);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}

}
