package com.webui.stepDefinitions;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.webui.baseURL.webuiCoreFunctions;
import com.webui.pageFactory.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_actions_ui extends webuiCoreFunctions {

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
		formpage.fillFirstName(firstName);
		formpage.fillLastName(lastName);
	}

	@Then("Fill the form with extended data")
	public void fillTheFormWithExtendedData() throws Throwable {
		HashMap<String, String> testData = Test_formData();
		System.out.println(testData.get("Date of Birth"));
		Assert.assertTrue(formpage.selectGender(testData.get("Gender"))
				&& formpage.fillDOB(testData.get("Date of Birth")) && formpage.fillEmail(testData.get("Email")));
		Thread.sleep(10000);
		// Gender - Male
		// Date of Birth - 05/01/1998
		// Email - testing@test.com
		// Mobile Number - 9876543210
		// College Name - ABC University
		// Degree - B.Tech
		// Type Stream - Computer Science
		// Year of Passing - 2020
		// College Location - New York
		// Message - From test data file
	}
}
