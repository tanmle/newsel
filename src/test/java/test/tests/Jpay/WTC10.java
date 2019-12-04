package test.tests.Jpay;

import org.testng.annotations.Test;

import com.core.utils.Logger;

import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.tests.DefaultObject;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class WTC10 extends LoginTest{
  @Test(description="Send email with prepaid  ")
  public void TestWTC10() {
	  Logger.info("Compose Ecard");
	  emailpage.composeEmail(dfObj.MailContent);
	  Logger.info("Check checkbox prepaid");
	  emailpage.SetCbPrepaid();
	  Logger.info("Send Email");
	  emailpage.SendMail(dfObj.RecipientName, dfObj.NotiSentMail);
	  Logger.info("Logout");
	  homepage.LogOut();
  }
  @BeforeMethod
  public void beforeMethod() {
  }
  DefaultObject dfObj=new DefaultObject();
  HomePage homepage=new HomePage();
  EmailPage emailpage=new EmailPage();
}
