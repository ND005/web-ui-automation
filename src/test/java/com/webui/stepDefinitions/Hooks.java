package com.webui.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.webui.baseURL.webuiBaseUrls;
import com.webui.stepDefinitions.DriverFactory.BrowserType;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	// Hardcode browser for example; in real life, read this from config/environment
	private final BrowserType browser = BrowserType.CHROME;

	@Before
	public void setup() {
		// 1. Create the driver using the Factory
		webuiBaseUrls baseUrls = new webuiBaseUrls();
		WebDriver driver = DriverFactory.createDriver(browser);

		// 2. Store the driver in the ThreadLocal manager
		DriverManager.setDriver(driver);
		driver.get(baseUrls.getWebAutomationUI());
	}

	@After
	public void tearDown() {
		// 3. Quit the driver and remove it from ThreadLocal
		DriverManager.quitDriver();
	}
}
