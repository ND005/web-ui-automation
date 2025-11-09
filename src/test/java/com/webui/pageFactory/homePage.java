package com.webui.pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
	private WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-home")
	public WebElement homePageNavigation;

	@FindBy(id = "nav-projects")
	public WebElement homeProjectNavigation;

	@FindBy(id = "nav-form")
	public WebElement homeFormNavigation;

	@FindBy(id = "nav-about")
	public WebElement homeAboutNavigation;

	@FindBy(xpath = "//h2[text()='Nimmala Dinesh']")
	public WebElement TitleVerification;

	public boolean navigateToHomePage() {
		wait.until(ExpectedConditions.visibilityOf(homePageNavigation)).click();
		if (driver.getTitle().contains("Home")) {
			return true;
		}
		return false;
	}

	public boolean navigateToProjectsPage() {
		wait.until(ExpectedConditions.visibilityOf(homeProjectNavigation)).click();
		wait.until(ExpectedConditions.titleContains("Projects"));
		if (driver.getTitle().contains("Projects")) {
			return true;
		}
		return false;
	}

	public boolean navigateToFormPage() {
		wait.until(ExpectedConditions.visibilityOf(homeFormNavigation)).click();
		wait.until(ExpectedConditions.titleContains("Form"));
		if (driver.getTitle().contains("Form")) {
			return true;
		}
		return false;
	}

	public boolean navigateToAboutPage() {
		wait.until(ExpectedConditions.visibilityOf(homeAboutNavigation)).click();
		wait.until(ExpectedConditions.titleContains("About"));
		if (driver.getTitle().contains("About")) {
			return true;
		}
		return false;
	}

	public boolean verifyTitle() {
		wait.until(ExpectedConditions.visibilityOf(TitleVerification));
		return true;
	}

}
