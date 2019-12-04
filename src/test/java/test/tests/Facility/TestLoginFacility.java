package test.tests.Facility;

import org.testng.annotations.Test;

import com.core.utils.Logger;

import test.data.user.UserData;
import test.pagesFacility.FacilityLoginPage;
import test.utils.TestBase;

import org.testng.annotations.BeforeMethod;

public class TestLoginFacility extends TestBase {
	  @BeforeMethod
	  public void beforeMethod() {
		  userData = userData.getData();
		  fLoginPage.goTo();
	  }
  @Test
  public void TestLogin() {
	  Logger.info(""
	  		+ "Input Username"
	  		+ "Input Pincode"
	  		+ "Input password"
	  		+ "Click Login");
	  fLoginPage.Login(userData.getUserFacility(),userData.getPincodeFacility(),userData.getPasswordFacility());
	  
  }

  UserData userData=new UserData();
  FacilityLoginPage fLoginPage=new FacilityLoginPage();
  
}
