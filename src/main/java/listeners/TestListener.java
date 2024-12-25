package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import TestBase.BaseClass;
import utils.ReportUtils;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		ReportUtils.test = ReportUtils.getExtent().createTest(testName);
		ReportUtils.test.info("Started Test: " + testName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String screenshotPath = ScreenshotUtils.takeScreenshot(BaseClass.driver, testName);
		ReportUtils.test.pass("Test passed." + testName).addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String screenshotPath = ScreenshotUtils.takeScreenshot(BaseClass.driver, testName);
		ReportUtils.test.fail("Test failed: " + testName).addScreenCaptureFromPath(screenshotPath);
		ReportUtils.test.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String screenshotPath = ScreenshotUtils.takeScreenshot(BaseClass.driver, testName);
		ReportUtils.test.skip("Test skipped: " + testName).addScreenCaptureFromPath(screenshotPath);
		ReportUtils.test.skip(result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		ReportUtils.setUpReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		ReportUtils.flushReport();
	}
}
