package com.runner;
//org.junit.runner.RunWith;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-json-report.json", "junit:target/cucumber-results.xml"},
		glue={"com.stepdefinition.steps"},
		features={"src/test/resources/feature"},
		monochrome=true
		)
public class TestRunner {

}
