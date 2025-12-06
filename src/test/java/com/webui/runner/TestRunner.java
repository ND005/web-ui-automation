package com.webui.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Test-Feature-Files", glue = { "com.webui.stepDefinitions" }, plugin = {
		"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json",
		"junit:target/surefire-reports/cucumber.xml" })
public class TestRunner {

}