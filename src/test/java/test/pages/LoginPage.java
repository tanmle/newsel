package test.pages;

import org.openqa.selenium.By;

import com.core.driver.DriverHelper;
import com.core.element.Element;

import test.utils.Constants;

public class LoginPage {

	public void goTo() {
		DriverHelper.navigate(Constants.URL);
	}

	public void login(String userName, String password) {
		userNameTextBox.waitForElementPresent();
		userNameTextBox.enter(userName);
		passwordTextBox.enter(password);
		loginButton.click();
	}

	private Element userNameTextBox = new Element(By.id("user"));
	private Element passwordTextBox = new Element(By.id("password"));
	private Element loginButton = new Element(By.id("login"));
}
