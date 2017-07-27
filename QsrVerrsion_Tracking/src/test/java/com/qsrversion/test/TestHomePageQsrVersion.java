package com.qsrversion.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qsrversion.annotations.TestInfo;
import com.qsrversion.excelutils.LoginPageData;
import com.qsrversion.pages.PageObjects;

public class TestHomePageQsrVersion extends PageObjects {

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "url" })
	public void setUp(String browser, String url) {
		driver = getWebDriver(browser);
		wait = new WebDriverWait(driver, 60);
		navigate(url);
	}

	@Test(testName = "Verify that user is on Homepage", description = "Verify that user is abe to login into eBos system", dataProvider = "TC_01", dataProviderClass = LoginPage_DataProvider.class, priority = 0)
	@TestInfo(testCaseID = "TC 01", testCaseDescription = "Verify that user is abe to login into eBos system")
	public void loginToHomePage(LoginPageData data) throws InterruptedException {

		// Login into the application
		getLoginPage(driver).loginIntoApplication(data.getUserName(), data.getPassWord());

		// For Dashboard
		wait.until(ExpectedConditions.elementToBeClickable(getLoginPage(driver).appVersion()));
		wait.until(ExpectedConditions.textToBePresentInElement(getLoginPage(driver).appVersion(), "dashboard"));
		System.out.println(getLoginPage(driver).appVersion().getText());
		String dashBoardVersion = (getLoginPage(driver).appVersion().getText()).replaceAll("[a-zA-Z :]", "");
		System.out.println("Dashboard Version : " + dashBoardVersion);

		// For cash
		wait.until(ExpectedConditions.elementToBeClickable(getLoginPage(driver).megaMenu));
		Thread.sleep(5000);
		getLoginPage(driver).megaMenu.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(getLoginPage(driver).drawerCount));
		getLoginPage(driver).drawerCount.click();
		wait.until(ExpectedConditions.elementToBeClickable(getLoginPage(driver).appVersion()));
		wait.until(ExpectedConditions.textToBePresentInElement(getLoginPage(driver).appVersion(), "cash"));
		System.out.println(getLoginPage(driver).appVersion().getText());
		String cashVersion = (getLoginPage(driver).appVersion().getText()).replaceAll("[a-zA-Z :]", "");
		System.out.println("Cash Version : " + cashVersion);

		// For Inventory
		wait.until(ExpectedConditions.elementToBeClickable(getLoginPage(driver).megaMenu));
		Thread.sleep(5000);
		getLoginPage(driver).megaMenu.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(getLoginPage(driver).physicalInventory));
		getLoginPage(driver).physicalInventory.click();
		wait.until(ExpectedConditions.elementToBeClickable(getLoginPage(driver).appVersion()));
		wait.until(ExpectedConditions.textToBePresentInElement(getLoginPage(driver).appVersion(), "inventory"));
		System.out.println(getLoginPage(driver).appVersion().getText());
		String inventoryVersion = (getLoginPage(driver).appVersion().getText()).replaceAll("[a-zA-Z :]", "");
		System.out.println("Inventory Version : " + inventoryVersion);

		// For Common Page
		wait.until(ExpectedConditions.elementToBeClickable(getLoginPage(driver).megaMenu));
		Thread.sleep(5000);
		getLoginPage(driver).megaMenu.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(getLoginPage(driver).commonPage));
		getLoginPage(driver).commonPage.click();
		wait.until(ExpectedConditions.elementToBeClickable(getLoginPage(driver).appVersion()));
		wait.until(ExpectedConditions.textToBePresentInElement(getLoginPage(driver).appVersion(), "dashboard"));
		System.out.println(getLoginPage(driver).appVersion().getText());
		String commonVersion = (getLoginPage(driver).appVersion().getText()).replaceAll("[a-zA-Z :]", "");
		System.out.println("Common Version : " + commonVersion);

		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream(System.getProperty("user.dir") + File.separator + "version.properties");

			// set the properties value
			prop.setProperty("dashBoardVersion", dashBoardVersion);

			prop.setProperty("cashVersion", cashVersion);

			prop.setProperty("inventoryVersion", inventoryVersion);

			prop.setProperty("commonVersion", commonVersion);

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// getHomePage(driver).clickOnNavigatorDropDown("Franchise Navigator");
		driver.quit();
	}
}
