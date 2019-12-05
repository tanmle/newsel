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
		clickEmailonTop();
		clickCompose();
		inputMail(content);
	}
	public String sendMail(String recipientName, String notiSentMail)
	{
		
		clickBtnSendMail();
		Assert.assertEquals(getRecipientName(),recipientName);
		clickContinueCompose();
		Assert.assertEquals(getNotiSentEmail(),notiSentMail);
		String id=getIDletterSent();
		return id;
	}
	public void attachEcard(String categories)
	{
		clickBtnAttachEcard();
		selectEcardCategories(categories);
		selectRandomEcard();
		clickBtnContinueEcard();
	}
	public void uploadFile(String filepath)
	{
		clickAttachImage();
		btnChooseFile.shouldBe(visible);
		File file=new File(filepath);
		btnChooseFile.uploadFile(file);
		clickBtnAttachFileUpload();
		clickBtnContinueEcard();
	}
	//======================================================================================================
	public void clickInbox()
	{
		lnkInbox.shouldBe(visible);
		lnkInbox.click();
	}
	public void clickCompose()
	{
		lnkCompose.shouldBe(visible);
		lnkCompose.click();
	}
	public void clickSent()
	{
		lnkSent.shouldBe(visible);
		lnkSent.click();
	}
	public void clickBuyStamps()
	{
		lnkBuyStamps.shouldBe(visible);
		lnkBuyStamps.click();
	}
	public void clickTransferStamps()
	{
		lnkTransferStamps.shouldBe(visible);
		lnkTransferStamps.click();
	}
	public void clickTransactionHistory()
	{
		lnkTransactionHistory.shouldBe(visible);
		lnkTransactionHistory.click();
	}
	public void clickBtnSendMail()
	{
		btnSendMail.shouldBe(visible);
		btnSendMail.click();
	}
	public void clickCancelSendMail()
	{
		btnCancelSendMail.shouldBe(visible);
		btnCancelSendMail.click();
	}
	public void clickBtnAttachEcard()
	{
		btnAttachEcard.shouldBe(visible);
		btnAttachEcard.click();
	}
	public void clickAttachImage()
	{
		btnAttachImage.shouldBe(visible);
		btnAttachImage.click();
	}
	public void setCbPrepaid()
	{
		cbPrepaid.shouldBe(visible);
		cbPrepaid.setSelected(true);
	}
	public void clickPreview()
	{
		btnPreview.shouldBe(visible);
		btnPreview.click();
	}
	public void inputMail(String mess)
	{
		DateFormat datefm=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date=new Date();
		String date1=datefm.format(date);
		txtInputMail.shouldBe(visible);
		txtInputMail.setValue(mess+" "+date1);
	}
	public void clickBackCompose()
	{
		btnBackCompose.shouldBe(visible);
		btnBackCompose.click();
	}
	public void clickContinueCompose()
	{
		btnContinueCompose.shouldBe(visible);
		btnContinueCompose.click();
	}
	public String getNotiSentEmail()
	{
		lbSentMail.shouldBe(visible);
		String noti=lbSentMail.getText();
		return noti;
	}
	public String getRecipientName()
	{
		lbRecipientName.shouldBe(visible);
		String RecipientName=lbRecipientName.getText();
		return RecipientName;
	}
	public void selectEcardCategories(String categories)
	{
		cbbEcardCategories.shouldBe(visible);
		cbbEcardCategories.selectOptionContainingText(categories);
	}
	public void selectRandomEcard()
	{
		SelenideElement[] Ecard =new SelenideElement[] {lnkEcard1,lnkEcard2,lnkEcard3,lnkEcard4};
		Random rd=new Random();
		int rdarr=rd.nextInt(Ecard.length);
		Ecard[rdarr].click();
		//String xpath="//a[@id='"+n+"-attachmentId']";
		//$x(xpath).click();		
	}
	public void clickBtnContinueEcard()
	{
		btnContinueEcard.shouldBe(visible);
		btnContinueEcard.click();
	}
	public void clickLnkEcard1()
	{
		lnkEcard1.shouldBe(visible);
		lnkEcard1.click();
	}
	public void clickLnkEcard2()
	{
		lnkEcard2.shouldBe(visible);
		lnkEcard2.click();
	}
	public void clickEcard3()
	{
		lnkEcard3.shouldBe(visible);
		lnkEcard3.click();
	}
	public void clickEcard4()
	{
		lnkEcard4.shouldBe(visible);
		lnkEcard4.click();
	}

	public void clickBtnAttachFileUpload()
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
