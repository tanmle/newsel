package test.tests.Jpay;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.core.utils.Logger;

import test.data.user.UserData;
import test.pagesJpay.LoginPage;
import test.utils.TestBase;

@Test
public class LoginTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		userData = userData.getData();
		loginPage.goTo();
	}

	@Test(description = "Assign to | Without choosing any assign to")
	public void Login() throws InterruptedException {

		System.out.println(userData.getAddress());
		Logger.info(
				"Fill user name and password");
		Logger.info(
				"Click login");
		
		loginPage.login(userData.getAccount(),userData.getPassword());
	}
	LoginPage loginPage = new LoginPage();
	UserData userData = new UserData();
}