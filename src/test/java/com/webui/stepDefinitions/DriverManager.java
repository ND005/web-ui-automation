package com.webui.stepDefinitions;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	// ThreadLocal ensures that each thread running tests has its own WebDriver instance
    private static final ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();

    // 1. Get the driver instance for the current thread
    public static WebDriver getDriver() {
        return threadSafeDriver.get();
    }

    // 2. Set (Initialize) the driver instance for the current thread
    public static void setDriver(WebDriver driver) {
        threadSafeDriver.set(driver);
    }

    // 3. Remove the driver instance from the current thread after test completion
    public static void quitDriver() {
        if (threadSafeDriver.get() != null) {
            threadSafeDriver.get().quit();
            threadSafeDriver.remove(); // Essential for freeing the memory and ThreadLocal variable
        }
    }
}
