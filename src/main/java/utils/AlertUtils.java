package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertUtils {
	private WebDriver driver;
	private Alert alert;

	public AlertUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void acceptAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	public void dismissAlert() {
		 alert = driver.switchTo().alert();
		 alert.dismiss();
	}
	public void getAlertText() {
		alert = driver.switchTo().alert();
		alert.getText();
	}
	public void sendTextToAlert(String text) {
		alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

}
