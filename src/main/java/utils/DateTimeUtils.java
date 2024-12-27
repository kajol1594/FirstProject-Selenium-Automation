package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateTimeUtils {

	private WebDriver driver;
	private static SimpleDateFormat sdf;

	public DateTimeUtils(WebDriver driver) {
		this.driver = driver;

	}

	public static String getCurrentDateTime(String format) {
		sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	public static String getCurrentDateTime() {

		return getCurrentDateTime("yyyy-MM-dd HH:mm:ss");
	}

}
