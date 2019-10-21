package test.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.javafaker.Faker;

public class FakerHelper {

	private static Faker faker = new Faker();

	public static String getFullName() {
		return faker.name().fullName();
	}

	public static String getFirstName() {
		return faker.name().firstName();
	}

	public static String getLastName() {
		return faker.name().lastName();
	}

	public static String getEmail() {
		return faker.internet().emailAddress();
	}

	public static String getEmail(String domain) {
		return faker.name().username() + "@" + domain;
	}

	public static String getPlumFlowerEmail() {
		return getEmail("plumflowerinternational.com");
	}

	public static String getSentence() {
		return faker.lorem().sentence(2);
	}

	public static String getRandomUUID() {
		return UUID.randomUUID().toString();
	}

	public static String getSentence(int wordCount) {
		return faker.lorem().sentence(wordCount);
	}

	public static String getFixedString(int numberOfLetters) {
		return faker.lorem().fixedString(numberOfLetters);
	}

	public static String getTitle() {
		return getRandomUUID();
	}

	public static String getUsername() {
		return faker.name().firstName().toLowerCase() + "_" + System.currentTimeMillis();
	}

	public static String getNumberAsString(int numberOfDigits) {
		return String.valueOf(faker.number().randomNumber(numberOfDigits, true));
	}

	public static String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public static List<String> getTitle(int numberOfItem) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < numberOfItem; i++) {
			list.add(getRandomUUID());
		}
		return list;
	}

	public static List<String> getTitle(String prefix, int numberOfItem) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < numberOfItem; i++) {
			list.add(prefix + getRandomUUID());
		}
		return list;
	}
}
