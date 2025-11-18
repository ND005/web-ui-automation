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
	public void fillTheFormWithExtendedData() {
		HashMap<String, String> testData = Test_formData();
		Assert.assertTrue(formpage.selectGender(testData.get("Gender")) && formpage.fillEmail(testData.get("Email")));
		Assert.assertTrue(formpage.fillCollegeName(testData.get("College Name"))
				&& formpage.fillDegree(testData.get("Degree Type")) && formpage.fillStream(testData.get("Stream"))
				&& formpage.fillmessage(testData.get("Message"))
				&& formpage.fillCollegeLocation(testData.get("Location")));
		formpage.clickSubmitButton();
		// Year of Passing - 2020
		// DOB - 01/01/1998
		// Mobile Number - 9234567891
	}
}
