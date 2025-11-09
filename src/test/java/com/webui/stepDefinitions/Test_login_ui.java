package com.webui.stepDefinitions;
import org.openqa.selenium.WebDriver;
import com.webui.baseURL.webuiBaseUrls;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Test_login_ui {
	WebDriver driver = DriverManager.getDriver();
	webuiBaseUrls baseUrls = new webuiBaseUrls();
	
	@Given("^Login with valid (.*) and (.*)$")
	public void login_with_valid_admin_and_password(String username, String password) {
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}

	@Given("^Login with invalid (.*) and (.*)$")
	public void login_with_invalid_myname_and_password(String username, String password) {
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}

	@When("User logged in with valid credentials")
	public void validCredentialsTest() {

	}

	@When("User try to login with invalid credentials")
	public void invalidCredentialsTest() {

	}
}
