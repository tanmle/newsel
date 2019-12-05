package test.tests.Jpay;

import org.testng.annotations.Test;
import com.core.utils.Logger;
import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.utils.Constants;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class WTC10 extends LoginTest{
  @Test(description="Send email with prepaid  ")
  public void testWTC10() {
	  Logger.info("Compose Ecard");
	  emailpage.composeEmail(Constants.MAIL_CONTENT);
	  Logger.info("Check checkbox prepaid");
	  emailpage.setCbPrepaid();
	  Logger.info("Send Email");
	  emailpage.sendMail(Constants.RECIPIENT_NAME,Constants.NOTI_SENT_MAIL);
	  Logger.info("Logout");
	  homepage.logOut();
  }
  @BeforeMethod
  public void beforeMethod() {
  }
  HomePage homepage=new HomePage();
  EmailPage emailpage=new EmailPage();
}
