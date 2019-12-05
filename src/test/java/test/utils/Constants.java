package test.utils;

public class Constants {

	public static long TIME_OUT = 30;
	public static long SHORT_TIME_OUT = 10;

	public static final String BROWSER_SETTING_FILE = "src/test/resources/browsers.setting.properties";

	public static String URL = PropertiesHelper.getPropValue("profile.url");
	public static String URLFacility = PropertiesHelper.getPropValue("profile.urlFacility");
	public static String URLStaging=PropertiesHelper.getPropValue("profile.urlStaging");
	public static String INMATE="Michael Jordan, 0000000014, Jpay";
	public static String MAIL_CONTENT=" Sending clean letter from Jpay.com ";
	public static String WORD_FILTER="Filter";
	public static String DEFAULT_FILTER_WORD=" Gun, kill, kick";
	public static String RECIPIENT_NAME="MICHAEL JORDAN";
	public static String NOTI_SENT_MAIL="Sent!";
	public static String NOTI_SUCCESS_ADD_FILTER_WORD="Word was successfully added for all checked facilities.";
	public static String RELEASED="Released";
	public static String FLAGGED_INMATE="Requires Approval (Flagged inmate)";
	public static String FLAGGED_SENDER="Requires Approval (flagged sender)";
	public static String FLAGGED_WORD="Requires Approval (flagged words)";
	public static String REQUIRES_APPROVAL="Requires Approval";
	public static String[] ECARD_CATEGORIES=new String[] {"Flowers","Happiness","Fathers Day","Labor Day","Winter","Mother's Day","Get Back 2 Me"};
	public static String FILE_PATH_1="src/test/resources/FileUpload/dog.png";
}
