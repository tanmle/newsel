package com.core.browser;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.core.driver.manger.LocalDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxLocalDriver extends LocalDriverManager {

	@Override
	public void createWebDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.merge(getCapabilities());
		List<String> args = getArguments();
		if (args != null) {
			options.addArguments(args);
		}
		this.driver = new FirefoxDriver(options);
	}
}
