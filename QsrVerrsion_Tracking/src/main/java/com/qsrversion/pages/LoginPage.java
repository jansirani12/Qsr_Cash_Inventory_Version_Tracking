package com.qsrversion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public class LoginPage extends Common {
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// User Name
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_UsernameRegular']")
	public WebElement userNameTextBox;

	public WebElement userNameTextBox() {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_UsernameRegular']")));
		return driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_UsernameRegular']"));
	}

	// Password
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_PasswordTextBoxRegular']")
	public WebElement passWordTexrBox;

	public WebElement passwordTextBox() {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_PasswordTextBoxRegular']")));
		return driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_PasswordTextBoxRegular']"));
	}

	// Click on Login Button

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']")
	public WebElement loginButton;

	public WebElement loginButton() {
		return driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']"));
	}

	public void loginIntoApplication(String userName, String password) {
		// Switch control to frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='login_frame']")));
		wait.until(ExpectedConditions.visibilityOf(userNameTextBox));
		userNameTextBox.click();
		userNameTextBox.sendKeys(userName);
		Reporter.log("Enter user name as '" + userName + "'<br/>");
		wait.until(ExpectedConditions.visibilityOf(passWordTexrBox));
		passWordTexrBox.click();
		passWordTexrBox.sendKeys(password);
		Reporter.log("Enter password as '" + password + "'<br/>");
		loginButton.click();
		Reporter.log("Click on login button<br/>");
	}

	// Homepage Dashboard version
	@FindBy(xpath = "//div[@class='app_version']")
	public WebElement appVersion;

	public WebElement appVersion() {
		return driver.findElement(By.xpath("//div[@class='app_version']"));
	}

	@FindBy(xpath = "//a[@id='nav_menu_fa']")
	public WebElement megaMenu;

	@FindBy(xpath = "//a[text()='Drawer Countdown']")
	public WebElement drawerCount;

	@FindBy(xpath = "//a[text()='Physical Inventory']")
	public WebElement physicalInventory;

	@FindBy(xpath = "//a[text()='Audit']")
	public WebElement commonPage;

}
