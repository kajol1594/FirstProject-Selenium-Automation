package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {

	private WebDriver driver;
	private Select select;

	public DropdownUtils(WebDriver driver) {
		this.driver = driver;

	}

	public void selectByVisibleText(WebElement dropdown, String text) {
		select = new Select(dropdown);
		select.selectByVisibleText(text);
	}

	public void selectByValue(WebElement dropdown, String value) {
		select = new Select(dropdown);
		select.selectByValue(value);
	}

	public void selectByVisibleText(WebElement dropdown, int index) {
		select = new Select(dropdown);
		select.selectByIndex(index);
	}
}
