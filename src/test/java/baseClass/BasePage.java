package baseClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import actionDriver.ActionDriver;

public class BasePage extends BaseClass {
	public ActionDriver actionDriver;
	public JavascriptExecutor js;

	public BasePage() {
		js = (JavascriptExecutor) driver;
		this.actionDriver = new ActionDriver(driver);
		PageFactory.initElements(driver, this); // Initialize elements with PageFactory
	}

}
