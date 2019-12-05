package test.tests.Jpay;

import org.testng.annotations.Test;
import com.core.utils.Logger;
import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.utils.Constants;
import org.testng.annotations.BeforeMethod;

public class WTC14 extends LoginTest {
  @Test
  public void testWTC14() {
	  Logger.info("Compose Ecard");
	  emailPage.composeEmail(Constants.MAIL_CONTENT);
	  Logger.info("attach ecard 1");
	  emailPage.attachEcard(Constants.ECARD_CATEGORIES[0]);
	  Logger.info("attach ecard 2");
	  emailPage.attachEcard(Constants.ECARD_CATEGORIES[1]);
	  Logger.info("Click Send");
	  emailPage.sendMail(Constants.RECIPIENT_NAME, Constants.NOTI_SENT_MAIL);
	  Logger.info("logout");
	  homePage.logOut();
  }
  @BeforeMethod
  public void beforeMethod() {
  }
  HomePage homePage=new HomePage();
  EmailPage emailPage=new EmailPage();
}
