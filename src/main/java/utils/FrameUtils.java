package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FrameUtils {

	private WebDriver driver;

	public FrameUtils(WebDriver driver) {
		this.driver = driver;

	}

	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

}
