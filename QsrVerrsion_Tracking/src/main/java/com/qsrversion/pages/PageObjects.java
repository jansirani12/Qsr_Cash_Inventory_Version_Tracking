package com.qsrversion.pages;

import org.openqa.selenium.WebDriver;

public class PageObjects extends Common {
	public LoginPage getLoginPage(WebDriver driver) {
		return new LoginPage(driver);
	}
}
