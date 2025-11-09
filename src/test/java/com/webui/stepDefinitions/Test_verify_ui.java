package com.webui.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.webui.pageFactory.homePage;
import com.webui.pageFactory.loginPage;

import io.cucumber.java.en.Then;

public class Test_verify_ui {
	WebDriver driver = DriverManager.getDriver();
	loginPage loginpage = new loginPage(driver);
	homePage homepage = new homePage(driver);

	@Then("Verify intial screen and all expected elements")
	public void verifyIntialScreenAndElements() {
		Assert.assertTrue(homepage.TitleVerification.isDisplayed());
		Assert.assertTrue(homepage.homePageNavigation.isDisplayed());
		Assert.assertTrue(homepage.homeProjectNavigation.isDisplayed());
		Assert.assertTrue(homepage.homeFormNavigation.isDisplayed());
		Assert.assertTrue(homepage.homeFormNavigation.isDisplayed());
	}

	@Then("Verify the error popup")
	public void verifyTheError() {
		Assert.assertTrue(loginpage.isErrorPopupDisplayed());
	}
}
