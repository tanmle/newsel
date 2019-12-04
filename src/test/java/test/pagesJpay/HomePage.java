package test.pagesJpay;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertTrue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.core.element.Element.E;
import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Enabled;
import com.core.driver.DriverHelper;
import com.core.element.IElement;
import com.google.common.io.ByteArrayDataOutput;

import test.utils.Constants;


public class HomePage {
	public void LogOut()
	{
		ClickLnkHome();
		ClickBtnLogout();
	}
	
	public void checkLogin()
	{
		lnkHome.shouldBe(visible);
	}
	public void selectInmate(String inmate)
	{
		cbbSelectInmate.shouldBe(visible);
		cbbSelectInmate.selectOptionContainingText(inmate);
	}
	public void ClickEmailonTop()
	{
		lnkEmail.shouldBe(visible);
		lnkEmail.click();
	}
	public void ClickLnkHome()
	{
		lnkHome.shouldBe(visible);
		lnkHome.click();
	}
	public void ClickLnkSendMoney()
	{
		lnkSendMoney.shouldBe(visible);
		lnkSendMoney.click();
	}
	public void ClickLnkVideoVisitation()
	{
		lnkVideoVisitation.shouldBe(visible);
		lnkVideoVisitation.click();
	}
	public void ClickLnkMyAccount()
	{
		lnkMyAccount.shouldBe(visible);
		lnkMyAccount.click();
	}
	public void ClickBtnLogout()
	{
		btnLogout.shouldBe(visible);
		btnLogout.click();
	}
	SelenideElement btnLogout=$x("//div[@class=\"LogoutButton\"]");
	SelenideElement lnkMyAccount=$x("//a[@href=\"MyAccount.aspx\"]");
	SelenideElement lnkVideoVisitation=$x("//a[@href=\"JvisitMain.aspx\"]");
	SelenideElement lnkSendMoney=$x("//a[@href=\"SendMoney.aspx\"]");
	SelenideElement lnkHome=$x("//a[@href=\"home.aspx\"]");
	SelenideElement cbbSelectInmate=$x("//select[@name=\"inmatesDropDownList\"]");
	SelenideElement lnkEmail=$x("//a[@href=\"SendMail.aspx\"]");

}
