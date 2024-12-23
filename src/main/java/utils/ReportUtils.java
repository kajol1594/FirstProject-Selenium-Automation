package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {
    private static ExtentReports extent;
    public static ExtentTest test;

    public static void setUpReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports.html");
        spark.config().setDocumentTitle("Test Automation Report");
        spark.config().setReportName("Selenium Automation Testing");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
