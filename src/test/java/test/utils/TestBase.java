package test.utils;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.core.driver.DriverHelper;
import com.core.driver.DriverInfo;
import com.core.utils.DriverInfoHelper;

public class TestBase {

	@Parameters({ "browser" })
	@BeforeClass(alwaysRun = true)
	public void beforeMethod(String browser, Method method) {
		DriverInfo driverInfo = DriverInfoHelper
				.getDriverInfo(Constants.BROWSER_SETTING_FILE, browser);
		DriverHelper.createWebDriver(driverInfo);
		DriverHelper.maximizeBrowser();
	}

	@AfterClass(alwaysRun = true)
	public void afterMethod() {
		DriverHelper.quit();
	}

	@Parameters({ "browser" })
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(String browser) {
		String directoryName = System.getProperty("user.dir") + "/test-output/"
				+ "extent-report/";
		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		ExtentReporter.createReporter(directoryName + "test.html", browser,
				Constants.URL);
	}

	@BeforeMethod(alwaysRun = true)
	public void methodSetup(Method method) {
		System.out.println("Test name: " + method.getName());
		ExtentReporter.getTestReporter().startTest(method.getName(),
				this.getClass().getName());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		ExtentReporter.currentExtent()
				.attachReporter(ExtentReporter.currentHTMLReporter());
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		ExtentReporter.closeReport();
	}
}
