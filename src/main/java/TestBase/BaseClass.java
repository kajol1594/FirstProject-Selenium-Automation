package TestBase;

import java.util.*;
import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReportUtils;

public class BaseClass {
	public static WebDriver driver;
	protected static Properties properties;

	protected static Logger logger = LogManager.getLogger(BaseClass.class);

	@BeforeSuite
	public static void loadConfig() {
		ReportUtils.setUpReport();
		logger.info("Loading configuration file");
		properties = new Properties();

		String path = System.getProperty("user.dir") + "\\src\\test\\resources";

		try (FileInputStream fis = new FileInputStream(path + "\\config.properties")) {
			properties.load(fis);
			logger.info("Configuration loaded successfully.");
		} catch (IOException e) {
			System.err.println("Error loading config.properties file: " + e.getMessage());
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void setUP() throws InterruptedException {
		String browser = properties.getProperty("browser", "chrome").toLowerCase();// Default browser set to chrome

		if (browser.equalsIgnoreCase("chrome")) {
			logger.info("Initializing WebDriver...");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			logger.info("Initializing WebDriver...");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			logger.info("Initializing WebDriver...");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Unsupported browser" + browser);
		}

		int implicitwait = Integer.parseInt(properties.getProperty("ImplicitWait", "10"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitwait));
		driver.manage().window().maximize();
		logger.info("Navigating to URL: " + properties.getProperty("url"));
		driver.get(properties.getProperty("url"));
	}

	@BeforeMethod
	public void startTest(Method method) {
		String testName = method.getName();
		logger.info("Starting test: " + testName);
		ReportUtils.test = ReportUtils.getExtent().createTest(testName);
	}

	@AfterMethod
	public void endTest(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ReportUtils.test.fail("Test failed: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			ReportUtils.test.pass("Test passed.");
		} else if (result.getStatus() == ITestResult.SKIP) {
			ReportUtils.test.skip("Test Skip.");
		}

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();

		}
		ReportUtils.flushReport();
	}

}
