package utils;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitUtils {
	private static WebDriverWait wait;

	private static void initializeWait(WebDriver driver, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	}

	public static void waitForTheElementToBeVisible(WebDriver driver, WebElement element, int timeOut) {
		initializeWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForTheElementToBeClickable(WebDriver driver, WebElement element, int timeOut) {
		initializeWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	

	

}
