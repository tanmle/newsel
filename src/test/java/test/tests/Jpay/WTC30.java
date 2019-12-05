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

public class WTC30 extends LoginTest {
  @Test
  public void testWTC30() {
	  Logger.info("compose mail");
	  emailPage.composeEmail(Constants.MAIL_CONTENT+Constants.DEFAULT_FILTER_WORD);
	  Logger.info("Check checkbox prepaid");
	  emailPage.setCbPrepaid();
	  Logger.info("Send mail");
	  String idMail=emailPage.sendMail(Constants.RECIPIENT_NAME, Constants.NOTI_SENT_MAIL);
	  Logger.info("Logout"+ idMail);
	  homePage.logOut();
	  Logger.info("navigate to facility");
	  DriverHelper.navigate(Constants.URLFacility);
	  facilityLoginPage.login(userData.getUserFacility(),userData.getPinCodeFacility(), userData.getPassWordFacility());
	  facilityHomePage.searchMailByID(idMail);
	  Logger.info("check Status letter");
	  Assert.assertEquals(facilityHomePage.getStatusMail(),Constants.FLAGGED_WORD);
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
