package test.tests.Jpay;
import org.testng.annotations.Test;
import com.core.utils.Logger;
import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.tests.DefaultObject;
import org.testng.annotations.BeforeMethod;

public class WTC20 extends LoginTest{
  @Test
  public void TestWTC20() throws InterruptedException
  {
	  Logger.info("Compose email");
	  emailpage.composeEmail(dfObj.MailContent);
	  Logger.info("Attach Image");
	  emailpage.UploadFile(dfObj.URLfile1);
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
