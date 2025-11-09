package com.webui.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.webui.pageFactory.homePage;
import com.webui.pageFactory.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Test_login_ui {
	WebDriver driver = DriverManager.getDriver();
	loginPage loginpage = new loginPage(driver);
	homePage homepage = new homePage(driver);

	@Given("^Login with valid (.*) and (.*)$")
	public void loginWithValid_UserIDPassword(String username, String password) {
		Assert.assertTrue(loginpage.loginCredentials(username, password));

	}

	@Given("^Login with invalid (.*) and (.*)$")
	public void loginWithInvalid_UserIDPassword(String username, String password) {
		Assert.assertTrue(loginpage.loginCredentials(username, password));
	}

	@When("User logged in with valid credentials")
	public void validCredentialsTest() {
		Assert.assertTrue(homepage.navigateToHomePage());
	}
}
