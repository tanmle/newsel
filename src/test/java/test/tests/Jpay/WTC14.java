package test.tests.Jpay;

import org.testng.annotations.Test;

import com.core.utils.Logger;

import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.tests.DefaultObject;
import org.testng.annotations.BeforeMethod;

public class WTC14 extends LoginTest {
  @Test
  public void TestWTC14() {
	  Logger.info("Compose Ecard");
	  emailpage.composeEmail(dfObj.MailContent);
	  Logger.info("attach ecard 1");
	  emailpage.attachEcard(dfObj.ecardCategories[0]);
	  Logger.info("attach ecard 2");
	  emailpage.attachEcard(dfObj.ecardCategories[1]);
	  Logger.info("Click Send");
	  emailpage.SendMail(dfObj.RecipientName, dfObj.NotiSentMail);
	  Logger.info("logout");
	  homepage.LogOut();
  }
  @BeforeMethod
  public void beforeMethod() {
  }
  DefaultObject dfObj=new DefaultObject();
  HomePage homepage=new HomePage();
  EmailPage emailpage=new EmailPage();
}
