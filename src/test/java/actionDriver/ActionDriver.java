package actionDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDriver {

	private WebDriver driver;
	private WebDriverWait wait;

	public ActionDriver(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	// Click method using WebElement
	public void click(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Send keys method using WebElement
	public void sendKeys(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Get text method using WebElement
	public String getText(WebElement element) {
		String text = null;
		try {
			text = wait.until(ExpectedConditions.visibilityOf(element)).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	// Scroll to element method using WebElement
	public void scrollToElement(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Hover over element method using WebElement
	public void hoverOverElement(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to get the page title
	public String getPageTitle() {
		return driver.getTitle();
	}

	// Check if the element is displayed
	public boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element not visible: " + e.getMessage());
			return false;
		}
	}

	// Get attribute value of an element
	public String getAttribute(WebElement element, String attribute) {
		String attributeValue = null;
		try {
			attributeValue = element.getAttribute(attribute);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attributeValue;
	}

	// Get index of an element in a list of elements
	public int getIndex(WebElement element, By locator) {
		int index = -1;
		try {
			int count = driver.findElements(locator).size();
			for (int i = 0; i < count; i++) {
				if (driver.findElements(locator).get(i).equals(element)) {
					index = i;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return index;
	}

	// Check if the element is enabled
	public boolean isEnabled(WebElement element) {
		try {
			return element.isEnabled();
		} catch (Exception e) {
			System.out.println("Element not enabled: " + e.getMessage());
			return false;
		}
	}

	// Check if the element is selected
	public boolean isSelected(WebElement element) {
		try {
			return element.isSelected();
		} catch (Exception e) {
			System.out.println("Error while checking if the element is selected: " + e.getMessage());
			return false;
		}
	}

	// Check if the element is clickable
	public boolean isClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			System.out.println("Element not clickable: " + e.getMessage());
			return false;
		}
	}

	// Clear the text of an input field
	public void clearText(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element)).clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Select a value from a dropdown by visible text
	public void selectByVisibleText(WebElement element, String visibleText) {
		try {
			new org.openqa.selenium.support.ui.Select(element).selectByVisibleText(visibleText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Switch to alert
	public void acceptAlert() {
		try {
			wait.until(ExpectedConditions.alertIsPresent()).accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Dismiss alert
	public void dismissAlert() {
		try {
			wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Get the text from an alert
	public String getAlertText() {
		String alertText = null;
		try {
			alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alertText;
	}

}
