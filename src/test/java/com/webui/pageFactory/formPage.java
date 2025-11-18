package com.webui.pageFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class formPage {

	private WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public formPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstName")
	public WebElement firstNameField;

	@FindBy(id = "lastName")
	public WebElement lastNameField;

	@FindBy(id = "gender")
	public WebElement genderOptions;

	@FindBy(id = "dob")
	public WebElement DOBField;

	@FindBy(id = "email")
	public WebElement emailField;

	@FindBy(id = "phone")
	public WebElement mobileNumberField;

	@FindBy(id = "collegeName")
	public WebElement collegeNameField;

	@FindBy(id = "yearOfCompletion")
	public WebElement yearOfPassingField;

	@FindBy(id = "collegeLocation")
	public WebElement collegeLocationField;

	@FindBy(id = "degreeType")
	public WebElement TypeOfDegreeField;

	@FindBy(id = "stream")
	public WebElement streamField;

	@FindBy(id = "messageField")
	public WebElement messageField;

	@FindBy(id = "submitBtn")
	public WebElement SendButton;

	public boolean verifyFormElements() {
		if (firstNameField.isDisplayed() && lastNameField.isDisplayed() && SendButton.isDisplayed()
				&& genderOptions.isDisplayed() && DOBField.isDisplayed() && emailField.isDisplayed()
				&& mobileNumberField.isDisplayed() && collegeNameField.isDisplayed() && yearOfPassingField.isDisplayed()
				&& collegeLocationField.isDisplayed() && streamField.isDisplayed() && messageField.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void fillFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	public void fillLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public boolean selectGender(String Gender) {
		Select genderSelect = new Select(genderOptions);
		genderSelect.selectByVisibleText(Gender);
		return true;
	}

	public boolean fillDOB(String dob) {
		DOBField.sendKeys(dob);
		return true;
	}

	public boolean fillEmail(String email) {
		emailField.sendKeys(email);
		return true;
	}

	public boolean fillMobileNumber(String mobileNumber) {
		mobileNumberField.sendKeys(mobileNumber);
		return true;
	}

	public boolean fillCollegeName(String collegeName) {
		collegeNameField.sendKeys(collegeName);
		return true;
	}

	public boolean fillDegree(String degree) {
		Select degreeSelect = new Select(TypeOfDegreeField);
		degreeSelect.selectByVisibleText(degree);
		return true;
	}

	public boolean fillStream(String stream) {
		Select streamSelect = new Select(streamField);
		streamSelect.selectByVisibleText(stream);
		return true;
	}

	public boolean fillYearOfPassing(String year) {
		yearOfPassingField.sendKeys(year);
		return true;
	}

	public boolean fillCollegeLocation(String location) {
		collegeLocationField.sendKeys(location);
		return true;
	}

	public boolean fillmessage(String message) {
		messageField.sendKeys(message);
		return true;
	}

	public void clickSubmitButton() {
		SendButton.click();
	}
}
