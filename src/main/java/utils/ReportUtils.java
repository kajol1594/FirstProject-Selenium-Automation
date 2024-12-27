package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {
	protected static ExtentReports extent;
	public static ExtentTest test;

	public static void setUpReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports.html");
		spark.config().setDocumentTitle("Selenium Automation Framework From Scratch");
		spark.config().setReportName("Selenium Automation Testing Report");
		//extent.setSystemInfo("OS",System.getProperty("os.name"));
		//extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		//extent.setSystemInfo("User", System.getProperty("user.name"));
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	public static void flushReport() {
		if (extent != null) {
			extent.flush();
		}
	}

	public static ExtentReports getExtent() {

		return extent;
	}
}
