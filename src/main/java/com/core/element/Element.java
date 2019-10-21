package com.core.element;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.driver.DriverHelper;
import com.core.utils.Logger;

public class Element implements IElement {

	private By byLocator;
	private WebElement webElement;
	private String dynamicLocator;

	private By getByLocator(String locator) {
		String body = locator.replaceAll("[\\w\\s]*=(.*)", "$1").trim();
		String type = locator.replaceAll("([\\w\\s]*)=.*", "$1").trim();
		switch (type) {
		case "css":
			return By.cssSelector(body);
		case "id":
			return By.id(body);
		case "link":
			return By.linkText(body);
		case "xpath":
			return By.xpath(body);
		case "text":
			return By.xpath(String.format("//*[contains(text(), '%s')]", body));
		case "name":
			return By.name(body);
		default:
			return By.xpath(locator);
		}
	}

	@Override
	public WebElement getElement() {
		if (this.webElement == null) {
			this.webElement = waitForElementPresent();
		} else {
			try {
				this.webElement.isEnabled();
			} catch (StaleElementReferenceException e) {
				this.webElement = waitForElementPresent();
			}
		}
		return this.webElement;
	}

	private WebElement getElement(long timeOutInSeconds) {
		if (this.webElement == null) {
			this.webElement = waitForElementPresent(timeOutInSeconds);
		} else {
			try {
				this.webElement.isEnabled();
			} catch (StaleElementReferenceException e) {
				this.webElement = waitForElementPresent(timeOutInSeconds);
			}
		}
		return this.webElement;
	}

	private WebDriver getDriver() {
		return DriverHelper.getDriver();
	}

	public Element(String locator) {
		this.webElement = null;
		this.dynamicLocator = locator;
		this.byLocator = getByLocator(locator);
	}

	public Element(By locator) {
		this.webElement = null;
		this.byLocator = locator;
	}

	public Element(WebElement element) {
		this.webElement = element;
	}

	@Override
	public void setDynamicValue(Object... args) {
		String locator = String.format(this.dynamicLocator, args);
		this.webElement = null;
		this.byLocator = getByLocator(locator);
	}

	@Override
	public By getLocator() {
		return this.byLocator;
	}

	@Override
	public void click() {
		WebElement element = getElement();
		element.click();
	}

	@Override
	public void clickByJS() {
		DriverHelper.executeJavaScript("arguments[0].click();", getElement());
	}

	@Override
	public void doubleClick() {
		Actions actions = new Actions(getDriver());
		actions.doubleClick(getElement());
	}

	@Override
	public String getText() {
		return getElement().getText();
	}

	@Override
	public String getAttribute(String name) {
		return getElement().getAttribute(name);
	}

	@Override
	public WebElement waitForElementPresent(long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		return wait.until(ExpectedConditions.presenceOfElementLocated(this.getLocator()));
	}

	@Override
	public WebElement waitForElementPresent() {
		return waitForElementPresent(DriverHelper.getTimeOut());
	}

	@Override
	public void enter(CharSequence... keysToSend) {
		WebElement element = getElement();
		element.sendKeys(keysToSend);
	}

	@Override
	public void enter(String value) {
		if (value != null && !value.equals("")) {
			getElement().sendKeys(value);
		}
	}

	@Override
	public boolean isDisplayed() {
		try {
			return getElement().isDisplayed();
		} catch (NoSuchElementException e) {
			Logger.debug("NoSuchElementException " + e.getMessage());
			return false;
		} catch (TimeoutException e) {
			Logger.debug("TimeoutException " + e.getMessage());
			return false;
		}
	}

	@Override
	public void moveTo() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(getElement()).build().perform();
	}

	@Override
	public boolean isDisplayed(long timeOutInSeconds) {
		try {
			return getElement(timeOutInSeconds).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} catch (TimeoutException e) {
			return false;
		}
	}

	@Override
	public boolean isEnabled() {
		return getElement().isEnabled();
	}

	@Override
	public void waitForTextPresent(String text) {
		waitForTextPresent(text, DriverHelper.getTimeOut());
	}

	@Override
	public void waitForTextPresent(String text, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(this.getLocator(), text));
	}

	@Override
	public WebElement getChildElement(By locator) {
		return getChildElement(locator, DriverHelper.getTimeOut());
	}

	@Override
	public WebElement getChildElement(By locator, long timeOutInSeconds) {

		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		return wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver arg0) {
				return getElement().findElement(locator);
			}
		});
	}

	@Override
	public boolean waitForElementInvisible() {
		return waitForElementInvisible(DriverHelper.getTimeOut());
	}

	@Override
	public WebElement getChildElement(String locator) {
		return getChildElement(getByLocator(locator));
	}

	@Override
	public String getXpathLocator() {
		String xpath = "";
		if (getLocator() instanceof ByXPath) {
			xpath = getLocator().toString().replaceAll("By.xpath: ", "");
		}
		return xpath;
	}

	@Override
	public boolean waitForElementInvisible(long timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(this.getLocator()));
		} catch (TimeoutException e) {
			return false;
		}
	}

	@Override
	public void clear() {
		getElement().clear();
	}

	@Override
	public int getNumberOfElements() {
		return getElements().size();
	}

	@Override
	public List<WebElement> getElements() {
		WebDriverWait wait = new WebDriverWait(getDriver(), DriverHelper.getTimeOut());
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.getLocator()));
	}

	@Override
	public void waitForElementsInvisible(long timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
			wait.until(ExpectedConditions.invisibilityOfAllElements(getDriver().findElement(this.getLocator())));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void waitForControlEnabled(long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(this.getLocator()));
	}

	@Override
	public void waitForControlEnabled() {
		waitForControlEnabled(DriverHelper.getTimeOut());
	}

	@Override
	public void scrollToView() {
		String js = "arguments[0].scrollIntoView(true);";
		DriverHelper.executeJavaScript(js, getElement());
	}

	@Override
	public void pressKeys(Keys key, String normalKey) {
		Actions actions = new Actions(getDriver());
		actions.keyDown(key).sendKeys(normalKey).keyUp(key).perform();
	}

	@Override
	public void pressKeys(Keys key) {
		Actions actions = new Actions(getDriver());
		actions.sendKeys(key).perform();
	}

	@Override
	public void clearByKeyboard() {
		click();
		pressKeys(Keys.CONTROL, "a");
		pressKeys(Keys.DELETE);
	}

	@Override
	public Point getLocation() {
		return getElement().getLocation();
	}

	@Override
	public int getElementSize() {
		return getElements().size();
	}

	@Override
	public List<String> getListText() {
		List<String> ret = new ArrayList<String>();
		List<WebElement> elements = getElements();
		for (WebElement e : elements) {
			ret.add(e.getText());
		}
		return ret;
	}

	@Override
	public boolean isDisabled() {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), DriverHelper.getTimeOut());
			return wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver arg0) {
					return !getElement().isEnabled();
				}
			});
		} catch (TimeoutException e) {
			Logger.debug("isDisabled: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean waitForElementDisplay(long timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
			return wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return driver.findElement(getLocator()).isDisplayed();
				}
			});
		} catch (Exception e) {
			Logger.debug("waitForElementDisplay: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean isScrollbarVisible() {
		String js = "var element = arguments[0]; return element.scrollHeight > element.clientHeight;";
		Object obj = DriverHelper.executeJavaScript(js, this.getElement());
		return (Boolean) obj;
	}

	@Override
	public boolean isScrolledToTheBottom() {
		String js = "var element = arguments[0]; return element.scrollTop === (element.scrollHeight - element.offsetHeight);";
		Object obj = DriverHelper.executeJavaScript(js, this.getElement());
		return (Boolean) obj;
	}

	@Override
	public void tryToClick() {
		try {
			click();
		} catch (Exception e) {
			Logger.debug(e.getMessage());
		}
	}

	@Override
	public String getTextContentByJs() {
		return (String) DriverHelper.executeJavaScript("return arguments[0].textContent;", this.getElement());
	}

	@Override
	public boolean waitForElementDisplay() {
		return waitForElementDisplay(DriverHelper.getTimeOut());
	}

	@Override
	public String getClassName() {
		return getAttribute("class");
	}
}
