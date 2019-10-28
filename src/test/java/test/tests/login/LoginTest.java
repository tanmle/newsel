package test.tests.login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.core.utils.Logger;

import test.data.user.UserData;
import test.pages.LoginPage;
import test.utils.TestBase;

@Test(groups = { "all", "customer-call", "customer-call-create",
		"customer-call-create-assign-to" })
public class LoginTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		userData = userData.getData();
		loginPage.goTo();
	}

	@Test(description = "Assign to | Without choosing any assign to")
	public void C2770() {

		System.out.println(userData.getAddress());
		Logger.info(
				"1. Fill in the Customer Call form, leaving the all 'assign to' is blank");
		Logger.info(
				"2. Fill in the Customer Call form, leaving the all 'assign to' is blank");
		Logger.info(
				"3. Fill in the Customer Call form, leaving the all 'assign to' is blank");
		loginPage.login("invalid", "invalid");
		assertTrue(false);
	}

	LoginPage loginPage = new LoginPage();
	UserData userData = new UserData();
}
