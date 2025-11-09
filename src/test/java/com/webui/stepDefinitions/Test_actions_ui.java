package com.webui.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.webui.pageFactory.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_actions_ui {
	
	WebDriver driver = DriverManager.getDriver();
	homePage homepage = new homePage(driver);
	formPage formpage = new formPage(driver);
	
	@When("^Switch to (.*) screen$")
	public void switchToForm_GUI(String screenName) {
	    homepage.navigateToPages(screenName);
	}

	@Then("Verify all form GUI elements")
	public void verifyAllguiElements() {
		Assert.assertTrue(formpage.verifyFormElements());
	}

	@Then("^Fill the form (.*) - (.*) details$")
	public void fillTheFormDetails(String firstName, String lastName) {
		
	}

	@Then("Fill the form with extended data")
	public void fillTheFormWithExtendedData() {
		
	}
}
