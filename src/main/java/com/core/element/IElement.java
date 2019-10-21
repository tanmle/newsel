package com.core.element;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public interface IElement {

	void click();

	void tryToClick();

	void clickByJS();

	void doubleClick();

	void moveTo();

	void clear();

	void clearByKeyboard();

	WebElement getElement();

	void enter(CharSequence... keysToSend);

	void enter(String value);

	String getText();
	
	String getTextContentByJs();

	String getAttribute(String name);

	WebElement waitForElementPresent();

	WebElement waitForElementPresent(long timeOutInSeconds);

	boolean waitForElementDisplay(long timeOutInSeconds);
	
	boolean waitForElementDisplay();

	void waitForTextPresent(String text);

	void waitForTextPresent(String text, long timeOutInSeconds);

	void waitForControlEnabled(long timeOutInSeconds);

	By getLocator();

	String getXpathLocator();

	void setDynamicValue(Object... args);

	boolean isDisplayed();

	boolean isDisplayed(long timeOutInSeconds);

	boolean isEnabled();

	boolean isDisabled();

	WebElement getChildElement(By locator);

	WebElement getChildElement(String locator);

	boolean waitForElementInvisible();

	boolean waitForElementInvisible(long timeOutInSeconds);

	void waitForElementsInvisible(long timeOutInSeconds);

	WebElement getChildElement(By locator, long timeOutInSeconds);

	List<WebElement> getElements();

	List<String> getListText();

	int getNumberOfElements();

	void scrollToView();

	boolean isScrollbarVisible();

	boolean isScrolledToTheBottom();

	void pressKeys(Keys key, String normalKey);

	void pressKeys(Keys key);

	Point getLocation();

	int getElementSize();

	void waitForControlEnabled();
	
	String getClassName();

}
