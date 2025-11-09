package com.webui.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Test-Feature-Files", glue = {"com.webui.stepDefinitions"}, plugin = {
		"pretty", "html:target/cucumber-reports.html" })
public class TestRunner {

}