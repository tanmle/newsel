package test.tests.Jpay;

import org.testng.annotations.Test;

import com.core.utils.Logger;

import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.tests.DefaultObject;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class WTC13 extends LoginTest{
  @Test
  public void TestWTC13() {
	  Logger.info("Compose Ecard");
	  emailpage.composeEmail(dfObj.MailContent);
	  Logger.info("attach ecard");
	  emailpage.attachEcard(dfObj.ecardCategories[2]);
	  Logger.info("Send mail");
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
