package com.core.utils;

import com.aventstack.extentreports.Status;

import test.utils.ExtentTestReporter;

public class Logger {

	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Logger.class);

	public static void info(Object message) {
		log.info(message);
	}

	public static void info(String message) {
		log.info(message);
		ExtentTestReporter.testReporters.get().log(Status.INFO, message);
	}

	public static void passed(String message) {
		log.info("CHECK POINT: " + message);
		ExtentTestReporter.testReporters.get().log(Status.PASS, message);
	}

	public static void failed(String message) {
		ExtentTestReporter.testReporters.get().log(Status.FAIL, message);
	}

	public static void skipped(String message) {
		log.info("TEST SKIPPED: " + message);
		ExtentTestReporter.testReporters.get().log(Status.SKIP, message);
	}

	public static void logToConsole(String message) {
		log.info(message);
	}

	public static void debug(String message) {
		log.debug(message);
	}
}
