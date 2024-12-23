
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	private WebDriver driver;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashboardHeader;
	

	// constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isDashboardDisplayed() {
		return dashboardHeader.isDisplayed();
	}

}
