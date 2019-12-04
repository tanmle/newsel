package test.pagesFacility;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.visible;
public class HomePageFacility {
	
	//========================================================================================================================
	public void SearchMailByID(String ID)
	{
		ClickLnkEmail();
		ClickSearch();
		SelectSearchbyID();
		InputtxtIDletter(ID);
		ClickbtnGoSearch();
		ClickLnkViewMail();
	}
	public void DeactivateFilterWord(String ftw)
	{
		ClickLnkEmail();
		ClicklnkWordFilterSystem();
		ClickSearchFilterWord();
		InputSearchFilterWord(ftw);
		ClickBtnGoSearchFilterWord();
		CheckCbCheckAllDeleteFilterWord();
		ClickBtnDeactivate();
	}
	//========================================================================================================================
	public void ClickLnkEmail()
	{
		LnkEmail.shouldBe(visible);
		LnkEmail.click();
	}
	public void SelectSearchbyID()
	{
		dropdSearchbytype.shouldBe(visible);
		dropdSearchbytype.selectOptionContainingText("Letter ID");
	}
	public void InputtxtIDletter(String id)
	{
		txtInputIDLetter.shouldBe(visible);
		txtInputIDLetter.setValue(id);
	}
	public void ClickbtnGoSearch()
	{
		btnGoSearch.shouldBe(visible);
		btnGoSearch.click();
	}
	public void ClickLnkViewMail()
	{
		lnkViewMail.shouldBe(visible);
		lnkViewMail.click();
	}
	public String GetStatusMail()
	{
		lbStatusMail.shouldBe(visible);
		String status=lbStatusMail.getText();
		return status;
	}
	public void ClickSearch()
	{
		lnkSearch.shouldBe(visible);
		lnkSearch.click();
	}
	public void ClickLogOut()
	{
		lnkLogOut.shouldBe(visible);
		lnkLogOut.click();
	}
	public void ClicklnkWordFilterSystem()
	{
		lnkWordFilterSystem.shouldBe(visible);
		lnkWordFilterSystem.click();
	}
	public void ClickAddFilterWord()
	{
		lnkAddFilterWord.shouldBe(visible);
		lnkAddFilterWord.click();
	}
	public void InputFilterWord(String ftw)
	{	
		ClickLnkEmail();
		ClicklnkWordFilterSystem();
		ClickAddFilterWord();
		txtInputWordFilter.setValue(ftw);
		ClickbtnAdd();
		
	}
	public void ClickbtnAdd()
	{
		btnAddword.shouldBe(visible);
		btnAddword.click();
	}
	public void ClickSearchFilterWord()
	{
		lnkSearchFilterWord.shouldBe(visible);
		lnkSearchFilterWord.click();
	}
	public void InputSearchFilterWord(String ftw)
	{
		txtInputSearchFilterWord.shouldBe(visible);
		txtInputSearchFilterWord.setValue(ftw);
	}
	public void ClickBtnGoSearchFilterWord()
	{
		btnGoSearchFilterWord.shouldBe(visible);
		btnGoSearchFilterWord.click();
	}
	public void CheckCbCheckAllDeleteFilterWord()
	{
		cbCheckAllDeleteFilterWord.shouldBe(visible);
		cbCheckAllDeleteFilterWord.setSelected(true);
	}
	public void ClickBtnDeactivate()
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
	SelenideElement LnkEmail=$x("//a[@href=\"./MailO.aspx\"]");

}
