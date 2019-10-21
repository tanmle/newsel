package test.utils;

import java.io.File;
import java.util.UUID;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.core.driver.DriverHelper;
import com.core.utils.Logger;
import com.epam.reportportal.message.ReportPortalMessage;

public class TestListener implements ITestListener {

	String log = "TEST CASE [%s.%s] - %s: %s";

	private String getLog(ITestResult result, String value) {
		return String.format(log,
				result.getTestClass().getRealClass().getCanonicalName(),
				result.getMethod().getMethodName(),
				result.getMethod().getDescription(), value);// "STARTED");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("\n");
		Logger.logToConsole(getLog(result, "STARTED"));
	}

	public void onTestSuccess(ITestResult result) {
		Logger.logToConsole(getLog(result, "PASSED"));
		Logger.passed("Test has been executed successfully without failure!");
	}

	public void onTestFailure(ITestResult result) {
		Logger.logToConsole(getLog(result, "FAILED"));
		StackTraceElement[] elements = result.getThrowable().getStackTrace();
		String trace = "<pre>" + result.getThrowable().getMessage() + "</pre>";
		for (StackTraceElement element : elements) {
			if (element.getClassName().startsWith("test")) {
				trace = trace + "<pre>" + element.toString() + "</pre>";
			}
		}

		try {
			String path = DriverHelper.captureScreenshot(
					UUID.randomUUID().toString(), "screenshots");
			if (!path.equals("")) {
				ReportPortalMessage message = new ReportPortalMessage(new File(path), "screenshot");
				Logger.info(message);
				String script = ScreenshotHelper.screenshotURI(path);
				if (script != null && !script.equals("")) {
					Logger.failed(trace + script);
					new File(path).delete();
				}
			}
		} catch (Exception e) {
			Logger.debug(e.getMessage());
		}

	}

	public void onTestSkipped(ITestResult result) {
		Logger.logToConsole(getLog(result, "SKIPPED"));
		StackTraceElement[] elements = result.getThrowable().getStackTrace();
		String trace = "<pre>" + result.getThrowable().getMessage() + "</pre>";
		for (StackTraceElement element : elements) {
			if (element.getClassName().startsWith("test")) {
				trace = trace + "<pre>" + element.toString() + "</pre>";
			}
		}
		Logger.skipped(trace);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		System.out.println("\n");
	}

}
