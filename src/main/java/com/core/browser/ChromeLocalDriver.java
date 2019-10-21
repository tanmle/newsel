package com.core.browser;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.core.driver.manger.LocalDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeLocalDriver extends LocalDriverManager {

	@Override
	public void createWebDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.merge(getCapabilities());
		List<String> args = getArguments();
		if (args != null) {
			options.addArguments(args);
		}
		this.driver = new ChromeDriver(options);
	}
}
