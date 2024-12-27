package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class WindowUtils {

	private WebDriver driver;

	public WindowUtils(WebDriver driver) {
		this.driver = driver;

	}

	public void switchToWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	public void switchToNewWindow(WebElement dropdown, String value) {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
		}

	}

}
