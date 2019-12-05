package test.tests.Jpay;

import org.testng.annotations.Test;
import com.core.driver.DriverHelper;
import com.core.utils.Logger;
import test.data.user.UserData;
import test.pagesFacility.FacilityLoginPage;
import test.pagesFacility.HomePageFacility;
import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.pagesJpay.LoginPage;
import test.utils.Constants;
import test.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class WTC33 extends TestBase{
  @Test
  public void TestWTC33() throws InterruptedException{
	  facilityLoginPage.goTo();
	  Assert.assertTrue(facilityLoginPage.login(userdata.getUserFacility(), userdata.getPinCodeFacility(), userdata.getPassWordFacility()));  
	  Logger.info("Input filter word");
	  facilityHomePage.inputFilterWord(Constants.WORD_FILTER);
	  Logger.info("Click signOut");
	  facilityHomePage.clickLogOut();
	  Logger.info("navigate to Jpay");
	  DriverHelper.navigate(Constants.URL);
	  Logger.info("Fill account and click login");
	  loginPage.login(userdata.getAccount(),userdata.getPassWord());
	  Logger.info("compose mail");
	  emailPage.composeEmail(Constants.MAIL_CONTENT+Constants.WORD_FILTER);
	  Logger.info("send");
	  String idLetter=emailPage.sendMail(Constants.RECIPIENT_NAME, Constants.NOTI_SENT_MAIL);
	  Logger.info("LogOut"+idLetter);
	  homePage.logOut();
	  Logger.info("navigate to facility");
	  DriverHelper.navigate(Constants.URLFacility);
	  facilityLoginPage.login(userdata.getUserFacility(),userdata.getPinCodeFacility(),userdata.getPassWordFacility());
	  Logger.info("Search mail");
	  facilityHomePage.searchMailByID(idLetter);
	  Assert.assertEquals(facilityHomePage.getStatusMail(),Constants.FLAGGED_WORD);
	  Logger.info("Deactivate filter word");
	  facilityHomePage.deActivateFilterWord(Constants.WORD_FILTER);
	  facilityHomePage.clickLogOut();
  }
  @BeforeMethod
  public void beforeMethod() {
	  userdata=userdata.getData();
	  
	  
  }
  FacilityLoginPage facilityLoginPage=new FacilityLoginPage();
  EmailPage emailPage=new EmailPage();
  HomePageFacility facilityHomePage=new HomePageFacility();
  LoginPage loginPage=new LoginPage();
  UserData userdata=new UserData();
  HomePage homePage=new HomePage();
}
