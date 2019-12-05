package test.tests.Jpay;

import org.testng.annotations.Test;

import com.core.driver.DriverHelper;
import com.core.utils.Logger;
import test.pagesFacility.FacilityLoginPage;
import test.pagesFacility.HomePageFacility;
import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
public class WTC29 extends LoginTest{
  @Test
  public void testWTC29() {
	  Logger.info("Compose email");
	  emailPage.composeEmail(Constants.MAIL_CONTENT);
	  Logger.info("Check checkbox prepaid");
	  emailPage.setCbPrepaid();
	  Logger.info("Click Send");
	  String idletter=emailPage.sendMail(Constants.RECIPIENT_NAME, Constants.NOTI_SENT_MAIL);
	  Logger.info("Logout");
	  homePage.logOut();
	  Logger.info("navigate to facility");
	  DriverHelper.navigate(Constants.URLFacility);
	  Assert.assertTrue(facilityLoginPage.login(userData.getUserFacility(),userData.getPinCodeFacility(), userData.getPassWordFacility()));
	  Logger.info("Search mail by id");
	  facilityHomePage.searchMailByID(idletter);
	  Logger.info("check Status letter");
	  Assert.assertEquals(facilityHomePage.getStatusMail(),Constants.RELEASED);
	  Logger.info("click Logout");
	  facilityHomePage.clickLogOut();
  }
  @BeforeMethod
  public void beforeMethod() {
	  
  }
  EmailPage emailPage=new EmailPage();
  HomePage homePage=new HomePage();
  FacilityLoginPage facilityLoginPage=new FacilityLoginPage();
  HomePageFacility facilityHomePage=new HomePageFacility();
  
}
