package test.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.core.element.Element.E;
import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.SelenideElement;
import com.core.driver.DriverHelper;
import com.core.element.IElement;

import test.utils.Constants;

public class LoginPage {

	public void goTo() {
		DriverHelper.navigate(Constants.URL);
	}

	public void login(String userName, String password) {
		selUserName.shouldBe(visible);
		selUserName.setValue(userName);
		selPassword.setValue(password);
		selPassword.hoverAndClick();
		dynamicSel("user").click();
		selLogin.click();
	}

	IElement selUserName = E("#user");
	IElement selPassword = E("#password");
	SelenideElement selLogin = $("#login");
	SelenideElement selLodgin = $(byText("login"));

	SelenideElement dynamicSel(String value) {
		return $x("//label[@for='" + value + "']");
	};
}
