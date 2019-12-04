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
	private String password;
	private String UserFacility;
	private String PincodeFacility;
	private String PasswordFacility;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUserFacility() {
		return UserFacility;
	}

	public void setUserFacility(String userFacility) {
		UserFacility = userFacility;
	}

	public String getPincodeFacility() {
		return PincodeFacility;
	}

	public void setPincodeFacility(String pincodeFacility) {
		PincodeFacility = pincodeFacility;
	}

	public String getPasswordFacility() {
		return PasswordFacility;
	}

	public void setPasswordFacility(String passwordFacility) {
		PasswordFacility = passwordFacility;
	}

}
