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
import test.tests.DefaultObject;
import test.utils.Constants;
import test.utils.TestBase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class WTC33 extends TestBase{
  @Test
  public void TestWTC33() throws InterruptedException{
	  falogin.goTo();
	  falogin.Login(userdata.getUserFacility(), userdata.getPincodeFacility(), userdata.getPasswordFacility());
	  Logger.info("Input filter word");
	  fahome.InputFilterWord(dfObj.wordfilter);
	  Logger.info("Click signOut");
	  fahome.ClickLogOut();
	  Logger.info("navigate to Jpay");
	  DriverHelper.navigate(Constants.URL);
	  Logger.info("Fill account and click login");
	  lgpage.login(userdata.getAccount(),userdata.getPassword());
	  Logger.info("compose mail");
	  emailpage.composeEmail(dfObj.wordfilter+" "+dfObj.MailContent);
	  Logger.info("send");
	  String idletter=emailpage.SendMail(dfObj.RecipientName, dfObj.NotiSentMail);
	  Logger.info("LogOut"+idletter);
	  hmPage.LogOut();
	  Logger.info("navigate to facility");
	  DriverHelper.navigate(Constants.URLFacility);
	  falogin.Login(userdata.getUserFacility(),userdata.getPincodeFacility(),userdata.getPasswordFacility());
	  Logger.info("Search mail");
	  fahome.SearchMailByID(idletter);
	 
	  Assert.assertEquals(fahome.GetStatusMail(),dfObj.FlaggedWord);
	  Logger.info("Deactivate filter word");
	  fahome.DeactivateFilterWord(dfObj.wordfilter);
	  fahome.ClickLogOut();
  }
  @BeforeMethod
  public void beforeMethod() {
	  userdata=userdata.getData();
	  
	  
  }
  FacilityLoginPage falogin=new FacilityLoginPage();
  EmailPage emailpage=new EmailPage();
  HomePageFacility fahome=new HomePageFacility();
  LoginPage lgpage=new LoginPage();
  UserData userdata=new UserData();
  HomePage hmPage=new HomePage();
  DefaultObject dfObj=new DefaultObject();
}
