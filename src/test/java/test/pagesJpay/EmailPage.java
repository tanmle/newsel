package test.pagesJpay;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.testng.Assert;
public class EmailPage extends HomePage {
	//======================================================================================================
	public void composeEmail(String content)
	{
		ClickEmailonTop();
		ClickCompose();
		InputMail(content);
	}
	public String SendMail(String RecipientName, String NotiSentMail)
	{
		
		ClickBtnSendMail();
		Assert.assertEquals(GetRecipientName(),RecipientName);
		ClickContinueCompose();
		Assert.assertEquals(GetNotiSentEmail(),NotiSentMail);
		String id=getIDletterSent();
		return id;
	}
	public void attachEcard(String categories)
	{
		ClickBtnAttachEcard();
		SelectEcardCategories(categories);
		SelectRandomEcard();
		ClickBtnContinueEcard();
	}
	public void UploadFile(String filepath)
	{
		ClickAttachImage();
		btnChooseFile.shouldBe(visible);
		File file=new File(filepath);
		btnChooseFile.uploadFile(file);
		ClickBtnAttachFileUpload();
		ClickBtnContinueEcard();
	}
	//======================================================================================================
	public void ClickInbox()
	{
		lnkInbox.shouldBe(visible);
		lnkInbox.click();
	}
	public void ClickCompose()
	{
		lnkCompose.shouldBe(visible);
		lnkCompose.click();
	}
	public void ClickSent()
	{
		lnkSent.shouldBe(visible);
		lnkSent.click();
	}
	public void ClickBuyStamps()
	{
		lnkBuyStamps.shouldBe(visible);
		lnkBuyStamps.click();
	}
	public void ClickTransferStamps()
	{
		lnkTransferStamps.shouldBe(visible);
		lnkTransferStamps.click();
	}
	public void ClickTransactionHistory()
	{
		lnkTransactionHistory.shouldBe(visible);
		lnkTransactionHistory.click();
	}
	public void ClickBtnSendMail()
	{
		btnSendMail.shouldBe(visible);
		btnSendMail.click();
	}
	public void ClickCancelSendMail()
	{
		btnCancelSendMail.shouldBe(visible);
		btnCancelSendMail.click();
	}
	public void ClickBtnAttachEcard()
	{
		btnAttachEcard.shouldBe(visible);
		btnAttachEcard.click();
	}
	public void ClickAttachImage()
	{
		btnAttachImage.shouldBe(visible);
		btnAttachImage.click();
	}
	public void SetCbPrepaid()
	{
		cbPrepaid.shouldBe(visible);
		cbPrepaid.setSelected(true);
	}
	public void ClickPreview()
	{
		btnPreview.shouldBe(visible);
		btnPreview.click();
	}
	public void InputMail(String mess)
	{
		DateFormat datefm=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date=new Date();
		String date1=datefm.format(date);
		txtInputMail.shouldBe(visible);
		txtInputMail.setValue(mess+" "+date1);
	}
	public void ClickBackCompose()
	{
		btnBackCompose.shouldBe(visible);
		btnBackCompose.click();
	}
	public void ClickContinueCompose()
	{
		btnContinueCompose.shouldBe(visible);
		btnContinueCompose.click();
	}
	public String GetNotiSentEmail()
	{
		lbSentMail.shouldBe(visible);
		String noti=lbSentMail.getText();
		return noti;
	}
	public String GetRecipientName()
	{
		lbRecipientName.shouldBe(visible);
		String RecipientName=lbRecipientName.getText();
		return RecipientName;
	}
	public void SelectEcardCategories(String categories)
	{
		cbbEcardCategories.shouldBe(visible);
		cbbEcardCategories.selectOptionContainingText(categories);
	}
	public void SelectRandomEcard()
	{
		SelenideElement[] Ecard =new SelenideElement[] {lnkEcard1,lnkEcard2,lnkEcard3,lnkEcard4};
		Random rd=new Random();
		int rdarr=rd.nextInt(Ecard.length);
		Ecard[rdarr].click();
		//String xpath="//a[@id='"+n+"-attachmentId']";
		//$x(xpath).click();		
	}
	public void ClickBtnContinueEcard()
	{
		btnContinueEcard.shouldBe(visible);
		btnContinueEcard.click();
	}
	public void ClickLnkEcard1()
	{
		lnkEcard1.shouldBe(visible);
		lnkEcard1.click();
	}
	public void ClickLnkEcard2()
	{
		lnkEcard2.shouldBe(visible);
		lnkEcard2.click();
	}
	public void ClickEcard3()
	{
		lnkEcard3.shouldBe(visible);
		lnkEcard3.click();
	}
	public void ClickEcard4()
	{
		lnkEcard4.shouldBe(visible);
		lnkEcard4.click();
	}

	public void ClickBtnAttachFileUpload()
	{
		btnAttachFileUpload.shouldBe(visible);
		btnAttachFileUpload.click();
	}
	public String getIDletterSent()
	{
		lbIDletterSent.shouldBe(visible);
		String IDletter=lbIDletterSent.getText();
		return IDletter;
	}
	SelenideElement lbIDletterSent=$x("//Span[@class=\"nLabelBlue\"]");
	SelenideElement btnAttachFileUpload=$x("//input[@id=\"btnAttach\"]");
	SelenideElement btnChooseFile=$x("//Input[@id=\"fuAttachment\"]");
	SelenideElement lnkEcard1=$x("//a[@id='0-attachmentId']");
	SelenideElement lnkEcard2=$x("//a[@id='1-attachmentId']");
	SelenideElement lnkEcard3=$x("//a[@id='2-attachmentId']");
	SelenideElement lnkEcard4=$x("//a[@id='3-attachmentId']");
	SelenideElement btnContinueEcard=$x("//input[@id=\"btnBack\"]");
	SelenideElement cbbEcardCategories=$x("//select[@name=\"ddlCategories2\"]");
	SelenideElement lbRecipientName=$x("//Span[@id=\"lblRecipient\"]");
	SelenideElement lbSentMail=$("#p_confirmation > section.ls_content_title > h2");
	SelenideElement btnContinueCompose=$x("//input[@id=\"btnSendLetter\"]");
	SelenideElement btnBackCompose=$x("//input[@id=\"btnBack\"]");
	SelenideElement txtInputMail=$x("//textarea[@id=\"message\"]");
	SelenideElement btnPreview=$x("//input[@id=\"bPreview2\"]");
	SelenideElement cbPrepaid=$x("//input[@id=\"cbSelfAddressed\"]");
	SelenideElement btnAttachImage=$x("//input[@id=\"imgBtnAttachment\"]");
	SelenideElement btnAttachEcard=$x("//input[@id=\"imgBtnEcard\"]");
	SelenideElement btnCancelSendMail=$x("//input[@id=\"btnCancel\"]");
	SelenideElement btnSendMail=$x("//input[@id=\"btnContinue\"]");
	SelenideElement lnkInbox=$x("//a[@href=\"IncomingMails.aspx\"]");
	SelenideElement lnkCompose=$x("//div[@class=\"nHeaderSubMenuStyleInDiv\"]//a[@href=\"SendMail.aspx\"]");
	SelenideElement lnkSent=$x("//div[@class=\"nHeaderSubMenuStyleInDiv\"]//a[@href=\"SendMail.aspx\"]");
	SelenideElement lnkBuyStamps=$x("//a[@href=\"BuyPostage.aspx\"]");
	SelenideElement lnkTransferStamps=$x("//a[@href=\"TransferStamps.aspx\"]");
	SelenideElement lnkTransactionHistory=$x("//a[@href=\"PurchaseHistory.aspx\"]");
}
