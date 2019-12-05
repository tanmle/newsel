package test.tests.Jpay;

import org.testng.annotations.Test;
import com.core.utils.Logger;
import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.utils.Constants;
import org.testng.annotations.BeforeMethod;

public class WTC01 extends LoginTest{
  @Test(description="Send email with clean letter")
  public void testWTC01() throws InterruptedException {
	  
	  Logger.info("compose Mail");
	  emailPage.composeEmail(Constants.MAIL_CONTENT);
	  Logger.info("send mail");
	  emailPage.sendMail(Constants.RECIPIENT_NAME, Constants.NOTI_SENT_MAIL);
	  Logger.info("Logout");
	  homePage.logOut();  
  }
  @BeforeMethod
  public void beforeMethod()  {
  }
  HomePage homePage=new HomePage();
  EmailPage emailPage=new EmailPage();
}
