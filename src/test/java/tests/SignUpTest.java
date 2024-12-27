package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pages.*;
import utils.ReportUtils;

@Listeners(listeners.TestListener.class)
public class SignUpTest extends BaseClass {

	private static SignUpPage signupPage;
	private static AccountInformationPage accountInfo;

	@Test(dataProvider = "SignupTestData", dataProviderClass = dataproviders.SignupDataProvider.class)
	public void validSignUp(String name, String email) {
		try {
			signupPage = new SignUpPage(driver);
			accountInfo = new AccountInformationPage(driver);
			ReportUtils.test.info("Clicking the Signup / Login menu...");
			signupPage.clickOnLoginSignupMenu();
			ReportUtils.test.info("Entering name...");
			signupPage.enterName(name);
			ReportUtils.test.info("Entering email...");
			signupPage.enterEmail(email);
			ReportUtils.test.info("Clicking the singup button...");
			signupPage.clickSignUpButton();
			// Verifying signup
			ReportUtils.test.info("Verifying the visible text at the next step...");
			Assert.assertTrue(accountInfo.isHeaderTextDisplayed(),
					"Expected  'Enter Account Information' text is not displayed.");
			ReportUtils.test.info("Proceed to next page...");
		} catch (Exception e) {
			ReportUtils.test.info("Test failed due to exception: " + e.getMessage());
			throw e;
		}

	}

}
