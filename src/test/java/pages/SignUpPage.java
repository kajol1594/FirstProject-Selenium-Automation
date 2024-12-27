package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ReportUtils;
import utils.WaitUtils;

public class SignUpPage {
	private WebDriver driver;
	private static final int DEFAULT_WAIT_TIME = 10;
	@FindBy(xpath = "//*[text()=' Signup / Login']")
	private WebElement menuLoginSignup;
	@FindBy(name = "name")
	private WebElement userName;
	@FindBy(xpath = "//input[@type='email'][@data-qa='signup-email']")
	private WebElement userEmail;
	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement signUpButton;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLoginSignupMenu() {
		try {
			WaitUtils.waitForTheElementToBeClickable(driver, menuLoginSignup, DEFAULT_WAIT_TIME);
			menuLoginSignup.click();
		} catch (Exception e) {
			ReportUtils.test.info("Error clicking Login/Signup menu: " + e.getMessage());
		}

	}

	public void enterName(String name) {
		try {
			WaitUtils.waitForTheElementToBeVisible(driver, userName, DEFAULT_WAIT_TIME);
			userName.clear();
			userName.sendKeys(name);
		} catch (Exception e) {
			ReportUtils.test.info("Error entering name in the Name field: " + e.getMessage());
		}
	}

	public void enterEmail(String email) {
		try {
			WaitUtils.waitForTheElementToBeVisible(driver, userEmail, DEFAULT_WAIT_TIME);
			userEmail.clear();
			userEmail.sendKeys(email);
		} catch (Exception e) {
			ReportUtils.test.info("Error entering email in the Email field: " + e.getMessage());
		}

	}

	public void clickSignUpButton() {
		try {
			WaitUtils.waitForTheElementToBeClickable(driver, signUpButton, DEFAULT_WAIT_TIME);
			signUpButton.click();
		} catch (Exception e) {
			ReportUtils.test.info("Error clicking Signup button: " + e.getMessage());
		}
	}
}
