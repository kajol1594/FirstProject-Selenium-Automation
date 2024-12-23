package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import pages.*;
import utils.ReportUtils;

public class LoginTest extends BaseClass {
	

	@Test
	public void testValidLogin() {
		 logger.info("Starting test: testValidLogin");
		 
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);

		// Perform login
		 logger.info("Entering username...");
		loginPage.enterUsername(properties.getProperty("username"));
		 logger.info("Entering password...");
		loginPage.enterPassword(properties.getProperty("password"));
		 logger.info("Clicking login button...");
		loginPage.clickLogin();
		
		// Assert successful login
		  logger.info("Verifying login was successful...");
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed after login.");
		 logger.info("Test passed: testValidLogin");
	}

	@Test
	public void testInvalidLogin() {
		
		LoginPage loginPage = new LoginPage(driver);
		

		loginPage.enterUsername(properties.getProperty("invalidUsername"));
		loginPage.enterPassword(properties.getProperty("invalidPassword"));
		loginPage.clickLogin();

		// Assert error message
		String expectedErrorMessage = "Invalid credentials";

		Assert.assertEquals(loginPage.getErrorMesg(), expectedErrorMessage, "Error message does not match.");

	}

}
