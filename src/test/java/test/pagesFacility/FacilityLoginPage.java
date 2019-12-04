package test.pagesFacility;

import com.codeborne.selenide.SelenideElement;
import com.core.driver.DriverHelper;

import test.utils.Constants;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;



public class FacilityLoginPage {
	public void goTo()
	{
		DriverHelper.navigate(Constants.URLFacility);
	}
	public void Login(String user,String pin, String password)
	{
		InputUsername(user);
		InputPincode(pin);
		InputPassword(password);
		ClickbtnLogin();
	}
	public void InputUsername(String username)
	{
		txtUsername.shouldBe(visible);
		txtUsername.setValue(username);
	}
	public void InputPincode(String pincode)
	{
		txtPincode.shouldBe(visible);
		txtPincode.setValue(pincode);
	}
	public void InputPassword(String pw)
	{
		txtPassword.shouldBe(visible);
		txtPassword.setValue(pw);
	}
	public void ClickbtnLogin()
	{
		btnLogin.shouldBe(visible);
		btnLogin.click();
	}
	SelenideElement btnLogin=$x("//input[@id=\"ctl00_MainContent_Button1\"]");
	SelenideElement txtPassword=$x("//input[@id=\"ctl00_MainContent_uPassword\"]");
	SelenideElement txtPincode=$x("//input[@id=\"ctl00_MainContent_uPin\"]");
	SelenideElement txtUsername=$x("//Input[@name=\"ctl00$MainContent$uUsername\"]");

}
