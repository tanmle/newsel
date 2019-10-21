package com.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

	public static void delay(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int extractNumber(String value) {
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(value);
		String temp = "";
		while (m.find()) {
			temp = temp + m.group();
		}
		return Integer.parseInt(temp);
	}

	public static String stripFileExtension(String fileName) {
		int dotInd = fileName.lastIndexOf('.');

		// if dot is in the first position,
		// we are dealing with a hidden file rather than an extension
		return (dotInd > 0) ? fileName.substring(0, dotInd) : fileName;
	}
}
