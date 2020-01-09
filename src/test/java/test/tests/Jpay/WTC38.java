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

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class WTC38 extends LoginTest{
  @Test(description="Letter sent to security")
  public void testWTC38() {
	  Logger.info("Compose email");
	  emailPage.composeEmail(Constants.MAIL_CONTENT);
	  Logger.info("Send mail");
	  String idMail=emailPage.sendMail(Constants.RECIPIENT_NAME, Constants.NOTI_SENT_MAIL);
	  Logger.info("navigate to facility");
	  DriverHelper.navigate(Constants.URLFacility);
	  Logger.info("login facility");
	  facilityLoginPage.login(userData.getUserFacility(), userData.getPinCodeFacility(), userData.getPassWordFacility());
	  Logger.info("search Mail");
	  facilityHomePage.searchMailByID(idMail);
	  Logger.info("click send to censored");
	  facilityHomePage.clickLnkSendToCensored();
	  Logger.info("Click button send to censored");
	  facilityHomePage.clickBtnSendToCensored();
	  Logger.info("confirm mail sent to censored");
	  Assert.assertEquals(facilityHomePage.getContentLetterSentCensored(), Constants.CENSORED_LETTER);
	  Logger.info("Logout Facility");
	  facilityLoginPage.clickLogOut();
  }
  @BeforeMethod
  public void beforeMethod() {
	  
  }
  FacilityLoginPage facilityLoginPage=new FacilityLoginPage();
  EmailPage emailPage=new EmailPage();
  HomePageFacility facilityHomePage=new HomePageFacility();
  LoginPage loginPage=new LoginPage();
  UserData userdata=new UserData();
  HomePage homePage=new HomePage();
}
