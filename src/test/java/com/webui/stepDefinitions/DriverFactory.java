package com.webui.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	// 1. Private Constructor to prevent instantiation (Utility Class)
	public enum BrowserType {
		CHROME, FIREFOX, EDGE, SAFARI
	}

	// 2. Main method to create the WebDriver instance
	public static WebDriver createDriver(BrowserType browser) {
		WebDriver driver;

		switch (browser) {
		case CHROME:
			// Use WebDriverManager to handle driver binary download and setup
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			// Add specific Edge initialization here if needed
			driver = new ChromeDriver(); // Edge is based on Chromium, uses ChromeDriver base class
			break;

		case SAFARI:
			// Safari typically doesn't need WebDriverManager on macOS
			driver = new SafariDriver();
			break;

		default:
			// Default to Chrome or throw an exception
			throw new IllegalArgumentException("Unsupported browser type: " + browser);
		}

		// 3. Common Configuration (applied to all browsers)
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}
}
