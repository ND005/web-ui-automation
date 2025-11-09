package com.webui.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	@FindBy(id = "username")
	public WebElement usernameField;

	@FindBy(id = "password")
	public WebElement passwordField;

	@FindBy(id = "loginBtn")
	public WebElement loginButton;

	@FindBy(id = "forgotLink")
	public WebElement forgetPassword;
}
