package com.core.element;

import static com.codeborne.selenide.WebDriverRunner.driver;

import org.openqa.selenium.By;

import com.codeborne.selenide.commands.Commands;
import com.codeborne.selenide.impl.ElementFinder;
import com.core.custom.commands.HoverAndClick;

public class Element {

	public static void setUp() {
		Commands.getInstance().add("hoverAndClick", new HoverAndClick());
	}

	public static IElement E(String selector) {
		return ElementFinder.wrap(driver(), IElement.class, null,
				By.cssSelector(selector), 0);
	}

	public static IElement EX(String selector) {
		return ElementFinder.wrap(driver(), IElement.class, null,
				By.xpath(selector), 0);
	}
}
