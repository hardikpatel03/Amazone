package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class Dashboard extends BasePage {

	@FindBy(xpath = "(//li[@class='nav-li'])[6]")
	private WebElement mobile;

	public void clickOnMobile() {
		actionDriver.click(mobile);
	}

	@FindBy(xpath = "//label[@for='apb-browse-refinements-checkbox_3']//i[@class='a-icon a-icon-checkbox']")
	private WebElement samsungBrandCheckbox;

	public void clickOnSamsungBrandCheckbox() {
		actionDriver.click(samsungBrandCheckbox);
	}

	@FindBy(xpath = "//span[text()='Smartwatches']/parent::a")
	private WebElement smartwatches;

	public void clickOnSmartwtaches() {
		actionDriver.click(smartwatches);
	}

	@FindBy(xpath = "//span[contains(text(),'Samsung Galaxy Watch Ultra (47mm, LTE, Silver) wit')]")
	private WebElement getTextWatchName;

	public String getTextgetTextWatchName() {
		return actionDriver.getText(getTextWatchName);
	}

	@FindBy(xpath = "//button[@id='a-autoid-1-announce']")
	private WebElement smartwatchesAddtocart;

	public void clickOnSmartwtacheAddtocart() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView(true);", smartwatchesAddtocart);
		Thread.sleep(2000);
		actionDriver.click(smartwatchesAddtocart);
		Thread.sleep(1000);
	}

	@FindBy(xpath = "//span[@id='nav-cart-count']")
	private WebElement clickOnAddtocart;

	public Add_to_cart clickOnclickOnAddtocart() throws InterruptedException {
		actionDriver.click(clickOnAddtocart);
		return new Add_to_cart();
	}

}
