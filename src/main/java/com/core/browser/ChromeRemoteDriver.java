package com.core.browser;

import java.util.List;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.driver.manger.RemoteDriverManager;

public class ChromeRemoteDriver extends RemoteDriverManager {

	@Override
	public void createWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.merge(getCapabilities());
		List<String> args = getArguments();
		if (args != null) {
			options.addArguments(args);
		}
		this.driver = new RemoteWebDriver(getRemoteUrl(), options);
	}
}
