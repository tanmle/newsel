package test.tests.Jpay;

import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;
import com.core.utils.Logger;

import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.tests.DefaultObject;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class WTC01 extends LoginTest{
  @Test(description="Send email with clean letter")
  public void TestWTC01() throws InterruptedException {
	  
	  Logger.info("compose Mail");
	  emailpage.composeEmail(dfObj.MailContent);
	  Logger.info("send mail");
	  emailpage.SendMail(dfObj.RecipientName, dfObj.NotiSentMail);
	  Logger.info("Logout");
	  homepage.LogOut();  
  }
  @BeforeMethod
  public void beforeMethod()  {
  }
  HomePage homepage=new HomePage();
  EmailPage emailpage=new EmailPage();
  DefaultObject dfObj=new DefaultObject();
  
  
}
