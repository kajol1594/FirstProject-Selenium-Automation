package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import pages.*;
import utils.ReportUtils;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseClass {
	
	
	@Test
	public void testValidLogin() {
		 
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);

		// Perform login
		ReportUtils.test.assignAuthor("Kajol Gupta");
		ReportUtils.test.assignCategory("Smoke Test");
		 ReportUtils.test.info("Entering username...");
		loginPage.enterUsername(properties.getProperty("username"));
		ReportUtils.test.info("Entering password...");
		loginPage.enterPassword(properties.getProperty("password"));
		 ReportUtils.test.info("Clicking login button...");
		loginPage.clickLogin();
		
		// Assert successful login
		ReportUtils.test.info("Verifying login was successful...");
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed after login.");
		 ReportUtils.test.pass("Test passed: testValidLogin");
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
