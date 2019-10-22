package test.tests.login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codeborne.selenide.Selenide;
import com.core.utils.Logger;

import test.pages.LoginPage;
import test.utils.TestBase;

@Test(groups = { "all", "customer-call", "customer-call-create",
		"customer-call-create-assign-to" })
public class LoginTest2 extends TestBase {

	@BeforeMethod
	public void setUp() {
		loginPage.goTo();
	}

	@Test(description = "Assign to | Without choosing any assign to")
	public void C2770_ok() {

		Logger.info(
				"4. Fill in the Customer Call form, leaving the all 'assign to' is blank");
		Logger.info(
				"5. Fill in the Customer Call form, leaving the all 'assign to' is blank");
		Logger.info(
				"6. Fill in the Customer Call form, leaving the all 'assign to' is blank");
		loginPage.login("invalid", "invalid");
		assertTrue(false, "fsdfsd");
	}

	LoginPage loginPage = new LoginPage();
}
