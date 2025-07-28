package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public Logger logger;

	public String downloadPath = System.getProperty("user.dir") + File.separator + "downloads";

	ChromeOptions options = new ChromeOptions();
	FirefoxOptions option = new FirefoxOptions();

	@BeforeTest
	public void loadConfig() {
		try (FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//configuration/config.properties")) {
			prop = new Properties();
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file");
		}
	}

	public void setUp() {
		logger = LogManager.getLogger(this.getClass());
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");

		if (browserName == null || browserName.isEmpty()) {
			throw new RuntimeException("Browser name is not specified in Config.properties file");
		}

		if (browserName.contains("Chrome")) {

			// options.addArguments("--disable-notifications");
			options.addArguments("--force-device-scale-factor=1.70");

			// Add the "--incognito" argument to the options
			options.addArguments("--incognito");
		
			downloadFileConfig();
			driver = new ChromeDriver(options);

		} else if (browserName.contains("Firefox")) {
			options.addArguments("--force-device-scale-factor=1.10");
			driver = new FirefoxDriver(option);
		} else {
			throw new RuntimeException("Unsupported browser: " + browserName);
		}

		driver.manage().window().maximize();

	}

	public void tearDown() {
		driver.quit();
	}

	public String verifyGetCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void downloadFileConfig() {
		options.addArguments("--force-device-scale-factor=1.2");// Browser zoom adjust code

		// Setup ChromeOptions to handle downloads
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-popup-blocking");
		// Set Chrome preferences for automatic download
		options.addArguments("download.default_directory=" + downloadPath);
		options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {
			{
				put("download.default_directory", downloadPath);
				put("download.prompt_for_download", false);
				put("safebrowsing.enabled", true);
			}
		});
	}

}
