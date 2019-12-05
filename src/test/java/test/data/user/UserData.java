package test.data.user;

import test.data.base.DataBase;

public class UserData extends DataBase {

	private static final String jsonFile = "src/test/resources/data/users.json";

	public UserData() {
		super(jsonFile);
	}

	private String name;
	private String age;
	private String address;
	private String account;
	private String passWord;
	private String userFacility;
	private String pinCodeFacility;
	private String passWordFacility;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserFacility() {
		return userFacility;
	}
	public void setUserFacility(String userFacility) {
		this.userFacility = userFacility;
	}
	public String getPinCodeFacility() {
		return pinCodeFacility;
	}
	public void setPinCodeFacility(String pinCodeFacility) {
		this.pinCodeFacility = pinCodeFacility;
	}
	public String getPassWordFacility() {
		return passWordFacility;
	}
	public void setPassWordFacility(String passWordFacility) {
		this.passWordFacility = passWordFacility;
	}
	

}

