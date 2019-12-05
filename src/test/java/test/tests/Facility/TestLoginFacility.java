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
		  facilityLoginPage.goTo();
	  }
  @Test
  public void TestLogin() {
	  Logger.info(""
	  		+ "Input Username"
	  		+ "Input Pincode"
	  		+ "Input password"
	  		+ "Click Login");
	  facilityLoginPage.login(userData.getUserFacility(),userData.getPinCodeFacility(),userData.getPassWordFacility());
	  
  }

  UserData userData=new UserData();
  FacilityLoginPage facilityLoginPage=new FacilityLoginPage();
  
}
