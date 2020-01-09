package test.tests.Jpay;

import org.testng.annotations.Test;
import com.codeborne.selenide.*;
import com.core.utils.Logger;
import jxl.read.biff.BiffException;
import test.pagesJpay.EmailPage;
import test.pagesJpay.HomePage;
import test.utils.Constants;
import test.utils.ReadExcelFile;
import java.io.IOException;
import org.testng.annotations.BeforeMethod;

public class WTC05 extends LoginTest{
	 @BeforeMethod
	 public void beforeMethod()  {
		  
	  }
  @Test(description="Send email with long letter")
  public void testWTC05() throws BiffException, IOException {
	  
	  Logger.info("compose Mail");
	  emailPage.composeEmail(readExcel.readCell(0, 0));
	  emailPage.clickOkPopupLongLetter();
	 // Selenide.confirm("Character Limit Reached");
	  Logger.info("send mail");
	  emailPage.sendMail(Constants.RECIPIENT_NAME, Constants.NOTI_SENT_MAIL);
	  Logger.info("Logout");
	  homePage.logOut(); 
	  
  }
  EmailPage emailPage=new EmailPage();
  HomePage homePage=new HomePage();
  ReadExcelFile readExcel=new ReadExcelFile();
}
