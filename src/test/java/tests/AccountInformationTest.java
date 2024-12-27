package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pages.*;
import utils.FrameUtils;

public class AccountInformationTest extends BaseClass {
	private static SignUpPage signupPage;
	private static AccountInformationPage acp;

	@Test(dataProvider = "SignupTestData", dataProviderClass = dataproviders.SignupDataProvider.class)
	public void validAccountInformationFlow(String name, String email, String password, int day, int month, String year,
			String firstName, String lastName, String company, String address1, String address2, String country,
			String state, String city, String zipCode, String mobileNumber) {

		signupPage = new SignUpPage(driver);

		// Step 1: Signup
		signupPage.clickOnLoginSignupMenu();
		signupPage.enterName(name);
		signupPage.enterEmail(email);
		signupPage.clickSignUpButton();

		// Step 2: Fill account details in the Account Information page
		acp = new AccountInformationPage(driver);
		// Handle iframe if it exists
		if (driver.findElements(By.id("aswift_7")).size() > 0) {
			driver.switchTo().frame("aswift_7");
			// close ad if present
			if (driver.findElements(By.xpath("//button[text()='Close']")).size() > 0) {
				driver.findElement(By.xpath("//button[text()='Close']")).click();
			}
			driver.switchTo().defaultContent();
		}
		
		// Proceed with filling account information
		acp.selectTitleMrs();
		acp.enterPassword(password);
		
		 // Scroll to the newsletter checkbox		
		
		WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletterCheckbox);
	    newsletterCheckbox.click();
	    
	    acp.checkForSpecialOffers();	    
	    acp.selectDayOfDOB(day);
		acp.selectMonthOfDOB(month);
		acp.selectYearOfDOB(year);

		// Scroll to the create account button
	    WebElement createAccountButton = driver.findElement(By.xpath("//*[text()='Create Account']"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountButton);
		
		// Step 3: enter address details

		acp.enterFirstname(firstName);
		acp.enterlastname(lastName);
		acp.enterCompany(company);
		acp.enterAddress1(address1);
		acp.enterAddress2(address2);
		acp.selectCountry(country);
		acp.enterState(state);
		acp.enterCity(city);
		acp.enterZipcode(zipCode);
		acp.enterMobileNumber(mobileNumber);

		// Step 4: Create Account
		
		// Scroll to "Create Account" button
	    WebElement createAccountBtn = driver.findElement(By.xpath("//*[text()='Create Account']"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);

		acp.clickOnCreateAccountButton();

	}

}
