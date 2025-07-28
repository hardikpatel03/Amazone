package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import baseClass.BasePage;

public class Add_to_cart extends BasePage {

	Dashboard dashboard;
	Add_to_cart add_to_cart;
	SoftAssert soft;

	@FindBy(xpath = "//span[@class='a-truncate-cut'][contains(text(),'Samsung Galaxy Watch Ultra (47mm, LTE, Silver) wit')]")
	private WebElement getTextWatchNameinCart;

	public String getTextgetTextWatchNameInCart() {
		return actionDriver.getText(getTextWatchNameinCart);
	}

	@FindBy(xpath = "//span[@class='a-icon a-icon-small-trash']")
	private WebElement RemoveProduct;

	public void clickOnRemoveProduct() {
		actionDriver.click(RemoveProduct);
	}

	@FindBy(xpath = "//h3[@class='a-size-large a-spacing-top-base sc-your-amazon-cart-is-empty']")
	private WebElement emptyCart;

	public String getTextemptyCart() {
		return actionDriver.getText(emptyCart);
	}

}
