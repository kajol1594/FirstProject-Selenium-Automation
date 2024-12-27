package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage {

	private WebDriver driver;
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	private WebElement AccountInfoHeader;
	@FindBy(id="id_gender1")
	private WebElement titleMr;
	@FindBy(id="id_gender2")
	private WebElement titleMrs;
	@FindBy(id="password")
	private WebElement enterPassword;
	@FindBy(id="days")
	private WebElement selectDayOfBirth;
	@FindBy(id="months")
	private WebElement selectMonthOfBirth;
	@FindBy(id="years")
	private WebElement selectYearOfBirth;
	@FindBy(id="newsletter")
	private WebElement subscribeNewsletter;
	@FindBy(id="optin")
	private WebElement recieveSplOffers;
	
	//Address information
	@FindBy(id="first_name")
	private WebElement firstName;
	@FindBy(id="last_name")
	private WebElement lastName;
	@FindBy(id="company")
	private WebElement enterCompany;
	@FindBy(id="address1")
	private WebElement enterAddress1;
	@FindBy(id="address2")
	private WebElement enterAddress2;
	@FindBy(id="country")
	private WebElement SelectCountry;
	@FindBy(id="state")
	private WebElement enterState;
	@FindBy(id="city")
	private WebElement enterCity;
	@FindBy(id="zipcode")
	private WebElement zip_code;
	@FindBy(id="mobile_number")
	private WebElement mobileNum;
	@FindBy(xpath = "//*[text()='Create Account']")
	private WebElement createAccountBtn;
	
	Select dayDropdown;

	public AccountInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isHeaderTextDisplayed() {
		return AccountInfoHeader.isDisplayed();
	}
	/*public void selectTitleMr() {
		titleMr.click();
	}*/
	public void selectTitleMrs() {
		titleMrs.click();
	}
	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}
	public void selectDayOfDOB(int index) {
		dayDropdown = new Select(selectDayOfBirth);
		dayDropdown.selectByIndex(index);
	}
	public void selectMonthOfDOB(int index) {
		dayDropdown = new Select(selectMonthOfBirth);
		dayDropdown.selectByIndex(index);
	}
	public void selectYearOfDOB(String Year) {
		dayDropdown = new Select(selectYearOfBirth);
		dayDropdown.selectByValue(Year);
	}
	public void checkForNewsletter() {
		subscribeNewsletter.click();
	}
	public void checkForSpecialOffers() {
		recieveSplOffers.click();
	}
	
	//---------------------Address Information-----------------//
	public void enterFirstname(String fname) {
		firstName.sendKeys(fname);
	}
	public void enterlastname(String lname) {
		lastName.sendKeys(lname);
	}
	public void enterCompany(String company) {
		enterCompany.sendKeys(company);
	}
	public void enterAddress1(String address1) {
		enterAddress1.sendKeys(address1);
	}
	public void enterAddress2(String address2) {
		enterAddress2.sendKeys(address2);
	}
	public void selectCountry(String country) {
		SelectCountry.sendKeys(country);
	}
	public void enterState(String state) {
		enterState.sendKeys(state);
	}
	public void enterCity(String city) {
		enterCity.sendKeys(city);
	}
	public void enterZipcode(String zipcode) {
		zip_code.sendKeys(zipcode);
	}
	
	public void enterMobileNumber(String mobile_Num) {
		mobileNum.sendKeys(mobile_Num);
	}
	public void clickOnCreateAccountButton() {
		createAccountBtn.click();
	}
	
	

}
