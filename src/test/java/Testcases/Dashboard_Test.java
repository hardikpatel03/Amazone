package Testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass;
import pageObjectModel.Add_to_cart;
import pageObjectModel.Dashboard;

public class Dashboard_Test extends BaseClass {

	Dashboard dashboard;
	Add_to_cart add_to_cart;
	SoftAssert soft;

	@BeforeClass
	public void launchBrowser() {
		setUp();
		driver.get(prop.getProperty("url"));
		dashboard = new Dashboard();
	}

	@AfterClass
	public void closedBrowser() {
		tearDown();
	}

	@BeforeMethod
	public void launchUrlCreateObject(ITestResult result) {
		soft = new SoftAssert();
		String testName = result.getMethod().getMethodName();		

	}


	@Test(priority = 1)
	public void verifyAmazoneLogoAndURL() throws InterruptedException {

		Thread.sleep(500);
		String verifyUrl = verifyGetCurrentUrl();
		soft.assertEquals(verifyUrl, "https://www.amazon.in/", "Url Mismatch");

		Thread.sleep(1000);
		soft.assertAll();
	}

	@Test(priority = 2)
	public void ApplyFilter() throws InterruptedException {

		dashboard.clickOnMobile();

		dashboard.clickOnSamsungBrandCheckbox();
		Thread.sleep(1000);
		dashboard.clickOnSmartwtaches();
		Thread.sleep(3000);
		String watchName = dashboard.getTextgetTextWatchName();

		System.out.println(watchName);
		Thread.sleep(1500);

		dashboard.clickOnSmartwtacheAddtocart();
		Thread.sleep(1000);
		add_to_cart = dashboard.clickOnclickOnAddtocart();
		Thread.sleep(1000);
		String watchText = add_to_cart.getTextgetTextWatchNameInCart();


		if (watchName.contentEquals(watchText)) {
			System.out.println(watchText);
		}

		Thread.sleep(1000);
		add_to_cart.clickOnRemoveProduct();

		driver.navigate().refresh();
		Thread.sleep(1500);
		String emptyCart = add_to_cart.getTextemptyCart();
		soft.assertEquals(emptyCart, "Your Amazon Cart is empty", "Product Text Mismatch");

		Thread.sleep(1000);
		soft.assertAll();
	}

}
