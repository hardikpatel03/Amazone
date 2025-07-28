package Testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass;
import pageObjectModel.Add_to_cart;
//import baseClass.ReporterManager;
import pageObjectModel.Dashboard;

public class Add_to_cart_Test extends BaseClass {

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



}
