package com.core.custom.commands;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementSource;
import com.core.element.IElement;

public class HoverAndClick implements Command<IElement> {

	@Override
	public IElement execute(SelenideElement proxy, WebElementSource locator,
			Object[] args) {
		System.out.println("This is HoverAndClick");
		return (IElement) proxy;
	}
}
