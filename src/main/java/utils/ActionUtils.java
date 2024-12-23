package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {

	private static ThreadLocal<Actions> action = new ThreadLocal<>();

	private static void initializeActions(WebDriver driver) {
		if (action.get() == null) {
			action.set(new Actions(driver));
		}

	}

	public static void hoverOverElement(WebElement element, WebDriver driver) {
		initializeActions(driver);
		action.get().moveToElement(element).perform();
	}

	public static void clickElement(WebElement element) {
		action.get().click(element).perform();
	}

}
