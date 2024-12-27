package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {

	private static Actions action;

	private static void initializeActions(WebDriver driver) {
		if (action == null) {
			action = new Actions(driver);
		}

	}

	public static void hoverOverElement(WebElement element, WebDriver driver) {
		initializeActions(driver);
		action.moveToElement(element).perform();
	}

	public static void clickElement(WebElement element) {
		action.click(element).perform();
	}

	public void doubleClick(WebElement element, WebDriver driver) {
		initializeActions(driver);
		action.doubleClick(element).perform();
	}

	public void rightClick(WebElement element, WebDriver driver) {
		initializeActions(driver);
		action.contextClick(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement target, WebDriver driver) {
		initializeActions(driver);
		action.dragAndDrop(source, target).perform();
	}

}
