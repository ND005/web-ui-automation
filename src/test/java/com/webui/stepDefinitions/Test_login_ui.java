package com.webui.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Test_login_ui {
	@Given("^Login with valid (.*) and (.*)$")
	public void login_with_valid_admin_and_password(String username, String password) {

	}

	@Given("^Login with invalid (.*) and (.*)$")
	public void login_with_invalid_myname_and_password(String username, String password) {

	}

	@When("User logged in with valid credentials")
	public void loginWithValidCredentials() {

	}

	@When("User try to login with invalid credentials")
	public void loginWithInvalidCredentials() {

	}

}
