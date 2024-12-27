package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	@FindBy(xpath="//*[text()=' Signup / Login']")
	private WebElement menuLoginSignup;
	@FindBy(name = "email")
	private WebElement usernameField;
	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;
	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	private WebElement errorMessage;
	

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnLoginSignupMenu() {
		menuLoginSignup.click();
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
