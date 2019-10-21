package com.core.driver;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.driver.manger.DriverManagerFactory;
import com.core.utils.Logger;

public class DriverHelper extends DriverManagerFactory {

	public static void createWebDriver(DriverInfo driverInfo) {
		initWebDriver(driverInfo);
	}

	public static WebDriver getDriver() {
		return getCurrentDriver();
	}

	public static long getTimeOut() {
		return getDefaultTimeOut();
	}

	public static void navigate(String url) {
		getDriver().get(url);
	}

	public static void quit() {
		getDriver().quit();
	}

	public static void refresh() {
		getDriver().navigate().refresh();
	}

	public static void maximizeBrowser() {
		try {
			getDriver().manage().window().maximize();
		} catch (Exception e) {
			Logger.debug(e.getMessage());
		}
	}

	public static String getCurrentAlertText() {
		String text = waitForAlertPresent().getText();
		Logger.debug("getCurrentAlertText: " + text);
		return text;
	}

	public static void dismissAlert() {
		waitForAlertPresent().dismiss();
	}

	public static Alert waitForAlertPresent() {
		WebDriverWait wait = new WebDriverWait(getCurrentDriver(), getTimeOut());
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static Object executeJavaScript(String script, Object... args) {
		return getJSExecutor().executeScript(script, args);
	}

	public static String captureScreenshot(String filename, String filepath) {
		String path = "";
		try {
			// Taking the screen using TakesScreenshot Class
			File objScreenCaptureFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

			// Storing the image in the local system.
			File dest = new File(
					System.getProperty("user.dir") + File.separator + filepath + File.separator + filename + ".png");
			FileUtils.copyFile(objScreenCaptureFile, dest);
			path = dest.getAbsolutePath();
		} catch (Exception e) {
		}
		return path;
	}
}
