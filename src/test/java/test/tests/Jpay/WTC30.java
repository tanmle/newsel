package test.tests.Jpay;

import org.testng.annotations.Test;

import com.core.driver.DriverHelper;
import com.core.utils.Logger;

import test.pagesFacility.FacilityLoginPage;
import test.pagesFacility.HomePageFacility;
import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.tests.DefaultObject;
import test.utils.Constants;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class WTC30 extends LoginTest {
  @Test
  public void TestWTC30() {
	  Logger.info("compose mail");
	  emailpage.composeEmail(dfObj.MailContent+dfObj.defaultFilterword);
	  Logger.info("Check checkbox prepaid");
	  emailpage.SetCbPrepaid();
	  Logger.info("Send mail");
	  String idmail=emailpage.SendMail(dfObj.RecipientName, dfObj.NotiSentMail);
	  Logger.info("Logout"+ idmail);
	  homepage.LogOut();
	  Logger.info("navigate to facility");
	  DriverHelper.navigate(Constants.URLFacility);
	  faLoginpge.Login(userData.getUserFacility(),userData.getPincodeFacility(), userData.getPasswordFacility());
	  homepageFa.SearchMailByID(idmail);
	  Logger.info("check Status letter");
	  Assert.assertEquals(homepageFa.GetStatusMail(),dfObj.FlaggedWord);
	  Logger.info("click Logout");
	  homepageFa.ClickLogOut();
  }
  @BeforeMethod
  public void beforeMethod() {
  }
  DefaultObject dfObj=new DefaultObject();
  EmailPage emailpage=new EmailPage();
  HomePage homepage=new HomePage();
  FacilityLoginPage faLoginpge=new FacilityLoginPage();
  HomePageFacility homepageFa=new HomePageFacility();
}
