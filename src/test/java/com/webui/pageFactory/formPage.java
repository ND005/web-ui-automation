package com.webui.pageFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

	@FindBy(id = "submitBtn")
	public WebElement SendButton;

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

	@FindBy(id = "stream")
	public WebElement streamField;

	@FindBy(id = "messageField")
	public WebElement messageField;
	
	public boolean verifyFormElements() {
		if (firstNameField.isDisplayed() && lastNameField.isDisplayed() && SendButton.isDisplayed()
				&& genderOptions.isDisplayed() && DOBField.isDisplayed() && emailField.isDisplayed()
				&& mobileNumberField.isDisplayed() && collegeNameField.isDisplayed()
				&& yearOfPassingField.isDisplayed() && collegeLocationField.isDisplayed()
				&& streamField.isDisplayed() && messageField.isDisplayed()) {
			return true;
		}
		return false;
	}
}
