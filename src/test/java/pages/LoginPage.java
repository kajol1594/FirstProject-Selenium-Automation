package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	@FindBy(xpath = "//input[@placeholder = 'Username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@placeholder = 'Password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement loginButton;
	@FindBy(xpath = "//*[text()=\"Invalid credentials\"]")
	private WebElement errorMessage;

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public String getErrorMesg() {
		return errorMessage.getText();
	}

}
