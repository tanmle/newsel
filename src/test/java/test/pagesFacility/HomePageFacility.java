package test.pagesFacility;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;
public class HomePageFacility {
	
	//========================================================================================================================
	public void searchMailByID(String ID)
	{
		clickLnkEmail();
		clickSearch();
		selectSearchbyID();
		inputtxtIDletter(ID);
		clickbtnGoSearch();
		clickLnkViewMail();
	}
	public void deActivateFilterWord(String ftw)
	{
		clickLnkEmail();
		clicklnkWordFilterSystem();
		clickAddFilterWord();
		inputFilterWord(ftw);
		clickAddFilterWord();
		checkCbCheckAllDeleteFilterWord();
		clickBtnDeactivate();
	}
	//========================================================================================================================
	public void clickLnkEmail()
	{
		lnkEmail.shouldBe(visible);
		lnkEmail.click();
	}
	public void selectSearchbyID()
	{
		dropdSearchbytype.shouldBe(visible);
		dropdSearchbytype.selectOptionContainingText("Letter ID");
	}
	public void inputtxtIDletter(String id)
	{
		txtInputIDLetter.shouldBe(visible);
		txtInputIDLetter.setValue(id);
	}
	public void clickbtnGoSearch()
	{
		btnGoSearch.shouldBe(visible);
		btnGoSearch.click();
	}
	public void clickLnkViewMail()
	{
		lnkViewMail.shouldBe(visible);
		lnkViewMail.click();
	}
	public String getStatusMail()
	{
		lbStatusMail.shouldBe(visible);
		String status=lbStatusMail.getText();
		return status;
	}
	public void clickSearch()
	{
		lnkSearch.shouldBe(visible);
		lnkSearch.click();
	}
	public void clickLogOut()
	{
		lnkLogOut.shouldBe(visible);
		lnkLogOut.click();
	}
	public void clicklnkWordFilterSystem()
	{
		lnkWordFilterSystem.shouldBe(visible);
		lnkWordFilterSystem.click();
	}
	public void clickAddFilterWord()
	{
		lnkAddFilterWord.shouldBe(visible);
		lnkAddFilterWord.click();
	}
	public void inputFilterWord(String ftw)
	{	
		clickLnkEmail();
		clicklnkWordFilterSystem();
		clickAddFilterWord();
		txtInputWordFilter.setValue(ftw);
		clickbtnAdd();
		
	}
	public void clickbtnAdd()
	{
		btnAddword.shouldBe(visible);
		btnAddword.click();
	}
	public void clickSearchFilterWord()
	{
		lnkSearchFilterWord.shouldBe(visible);
		lnkSearchFilterWord.click();
	}
	public void inputSearchFilterWord(String ftw)
	{
		txtInputSearchFilterWord.shouldBe(visible);
		txtInputSearchFilterWord.setValue(ftw);
	}
	public void clickBtnGoSearchFilterWord()
	{
		btnGoSearchFilterWord.shouldBe(visible);
		btnGoSearchFilterWord.click();
	}
	public void checkCbCheckAllDeleteFilterWord()
	{
		cbCheckAllDeleteFilterWord.shouldBe(visible);
		cbCheckAllDeleteFilterWord.setSelected(true);
	}
	public void clickBtnDeactivate()
	{
		btnDeactivate.shouldBe(visible);
		btnDeactivate.click();
	}
	public String getNotiSuccessAddfilterword()
	{
		lbNotiSuccessAddfilterword.shouldBe(visible);
		String noti=lbNotiSuccessAddfilterword.getText();
		return noti;
	}
	public void clickLnkSendToCensored()
	{
		lnkSendToCensored.shouldBe(visible);
		lnkSendToCensored.click();
	}
	public void clickBtnSendToCensored()
	{
		btnSendToCensored.shouldBe(visible);
		btnSendToCensored.click();
	}
	public String getContentLetterSentCensored()
	{
		lbLetterSendCensored.shouldBe(visible);
		 String ct =lbLetterSendCensored.getText();
		 return ct;
	}
	SelenideElement lbLetterSendCensored=$("#ctl00_MainContent_lblLetterSent");
	SelenideElement btnSendToCensored=$("#ctl00_MainContent_btn_security");
	SelenideElement lnkSendToCensored=$("#ctl00_MainContent_lnk_Censore");
	SelenideElement lbNotiSuccessAddfilterword=$x("//span[@id=\"ctl00_MainContent_lblResultMessage\"]");
	SelenideElement btnDeactivate=$x("//input[@id=\"ctl00_MainContent_btnDeleteAll\"]");
	SelenideElement cbCheckAllDeleteFilterWord=$x("//input[@id=\"ctl00_MainContent_MyDataGridSearchDictionary_ctl01_CheckAllDelete\"]");
	SelenideElement btnGoSearchFilterWord=$x("//input[@name=\"ctl00$MainContent$btnSubmit\"]");
	SelenideElement txtInputSearchFilterWord=$x("//input[@id=\"ctl00_MainContent_searchstring\"]");
	SelenideElement lnkSearchFilterWord=$x("//a[@id=\"ctl00_MainContent_Linkbutton3\"]");
	SelenideElement btnAddword=$x("//input[@id=\"ctl00_MainContent_btn_addword\"]");
	SelenideElement txtInputWordFilter=$x("//input[@id=\"ctl00_MainContent_addWord\"]");
	SelenideElement lnkAddFilterWord=$x("//a[@id=\"ctl00_MainContent_Linkbutton2\"]");
	SelenideElement lnkWordFilterSystem=$x("//a[@href=\"FilterSys.aspx\"]");
	SelenideElement lnkLogOut=$x("//a[@id=\"ctl00_Header_MenuRepeater_ctl13_lnkLogout\"]");
	SelenideElement lnkSearch=$x("//a[@href=\"SearchByMail.aspx\"]");
	SelenideElement lbStatusMail=$x("//span[@id=\"ctl00_MainContent_lbl_titleheader\"]");
	SelenideElement lnkViewMail=$x("//a[@id=\"ctl00_MainContent_LetterMailSummary_dgLetterMailSummary_ctl03_hlViewLetter\"]");
	SelenideElement btnGoSearch=$x("//input[@id=\"ctl00_MainContent_btnGo\"]");
	SelenideElement txtInputIDLetter=$x("//input[@id=\"ctl00_MainContent_tbSearch\"]");
	SelenideElement dropdSearchbytype=$x("//Select[@id=\"ctl00_MainContent_ddlsearchOptionLevel1\"]");
	SelenideElement lnkEmail=$x("//a[@href=\"./MailO.aspx\"]");

}
