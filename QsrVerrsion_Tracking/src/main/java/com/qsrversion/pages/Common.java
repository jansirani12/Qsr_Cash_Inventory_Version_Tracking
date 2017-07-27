package com.qsrversion.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;

	public Common(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		action = new Actions(driver);
	}

	public Common(String browser) {
		getWebDriver(browser);
	}

	public Common() {
	}

	public WebDriver getWebDriver(String browser) {
		switch (browser) {
		case "internet-explorer":
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\Drivers\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities.setCapability(
					InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			FirefoxProfile ffprofile = new FirefoxProfile();
			ffprofile.setPreference("javascript.enabled", true);
			driver = new FirefoxDriver(ffprofile);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\Drivers\\chromedriver.exe");
			System.out.println(System.getProperty("user.dir")
							+ "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			break;
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

	public void navigate(String applicationURL) {
		driver.get(applicationURL);

	}

}
