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

}
