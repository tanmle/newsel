package test.tests.Jpay;
import org.testng.annotations.Test;
import com.core.utils.Logger;
import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.utils.Constants;

import org.testng.annotations.BeforeMethod;

public class WTC20 extends LoginTest{
  @Test
  public void testWTC20() throws InterruptedException
  {
	  Logger.info("Compose email");
	  emailPage.composeEmail(Constants.MAIL_CONTENT);
	  Logger.info("Attach Image");
	  emailPage.uploadFile(Constants.FILE_PATH_1);
	  Logger.info("Send mail");
	  emailPage.sendMail(Constants.RECIPIENT_NAME, Constants.NOTI_SENT_MAIL);
	  Logger.info("Logout");
	  homePage.logOut();
  }
  @BeforeMethod
  public void beforeMethod() {
  }
  HomePage homePage=new HomePage();
  EmailPage emailPage=new EmailPage();

}
