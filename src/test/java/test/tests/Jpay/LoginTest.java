package test.tests.Jpay;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codeborne.selenide.WebDriverRunner;
import com.core.utils.Logger;

import test.data.user.UserData;
import test.pagesJpay.HomePage;
import test.pagesJpay.LoginPage;
import test.utils.Constants;
import test.utils.TestBase;

@Test
public class LoginTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		userData = userData.getData();
		loginPage.goTo();
	}

	@Test(description = "Assign to | Without choosing any assign to")
	public void login() throws InterruptedException {

		System.out.println(userData.getAddress());
		Logger.info(
				"Fill user name and password");
		Logger.info(
				"Click login");
		loginPage.login(userData.getAccount(), userData.getPassWord());
		Assert.assertEquals(Constants.URL_HOME_JPAY, WebDriverRunner.url());
		homePage.selectInmate(Constants.INMATE);
	}
	LoginPage loginPage = new LoginPage();
	HomePage homePage=new HomePage();
	UserData userData = new UserData();
}
