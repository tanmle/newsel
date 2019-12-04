package test.pagesJpay;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.core.element.Element.E;
import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.SelenideElement;
import com.core.driver.DriverHelper;
import com.core.element.IElement;

import test.tests.DefaultObject;
import test.utils.Constants;

public class LoginPage extends HomePage{
	DefaultObject dfObj=new DefaultObject();
	public void goTo() {
		DriverHelper.navigate(Constants.URL);
	}

	public void login(String userName, String password) throws InterruptedException {
		btnLogin.shouldBe(visible);
		btnLogin.click();
		txtUserName.setValue(userName);
		txtPassword.setValue(password);
		btnLogin2.click();
		selectInmate(dfObj.Inmate);
	}

	
	SelenideElement btnLogin= $x("//a[@id=\"newHeader_TopRightNavButton_lnkLogin\"]/div");
	SelenideElement txtUserName=$x("//input[@id=\"uclLoginFirstTime_txtUserId\"]");
	SelenideElement txtPassword=$x("//input[@id=\"uclLoginFirstTime_txtPassword\"]");
	SelenideElement btnLogin2=$x("//a[@id=\"uclLoginFirstTime_btnContinue\"]/div");
	

}
