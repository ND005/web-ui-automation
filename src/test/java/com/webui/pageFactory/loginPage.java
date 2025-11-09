package com.webui.pageFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	private WebDriver driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	public WebElement usernameField;

	@FindBy(id = "password")
	public WebElement passwordField;

	@FindBy(id = "loginBtn")
	public WebElement loginButton;

	@FindBy(id = "forgotLink")
	public WebElement forgetPassword;

	@FindBy(id = "message")
	public WebElement errorPopup;

	public boolean loginCredentials(String username, String password) {
		if (usernameField.isDisplayed() && passwordField.isDisplayed() && loginButton.isDisplayed()) {
			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
			loginButton.click();
			return true;
		}
		return false;
	}

	public boolean isErrorPopupDisplayed() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			return false;
		}
		if (errorPopup.getText().contains("Invalid user name or password.") && errorPopup.isDisplayed()) {
			return true;
		}
		return false;
	}
}
