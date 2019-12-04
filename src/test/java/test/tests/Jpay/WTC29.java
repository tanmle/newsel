package test.tests.Jpay;

import org.testng.annotations.Test;

import com.core.driver.DriverHelper;
import com.core.utils.Logger;

import test.pagesFacility.FacilityLoginPage;
import test.pagesFacility.HomePageFacility;
import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.tests.DefaultObject;
import test.tests.Facility.TestLoginFacility;
import test.utils.Constants;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class WTC29 extends LoginTest{
  @Test
  public void TestWTC29() {
	  Logger.info("Compose email");
	  emailpage.composeEmail(dfObj.MailContent);
	  Logger.info("Check checkbox prepaid");
	  emailpage.SetCbPrepaid();
	  Logger.info("Click Send");
	  String idletter=emailpage.SendMail(dfObj.RecipientName, dfObj.NotiSentMail);
	  Logger.info("Logout");
	  homepage.LogOut();
	  Logger.info("navigate to facility");
	  DriverHelper.navigate(Constants.URLFacility);
	  faLoginpge.Login(userData.getUserFacility(),userData.getPincodeFacility(), userData.getPasswordFacility());
	  Logger.info("Search mail by id");
	  homepageFa.SearchMailByID(idletter);
	  Logger.info("check Status letter");
	  Assert.assertEquals(homepageFa.GetStatusMail(),dfObj.Released);
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
