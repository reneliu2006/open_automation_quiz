package com.cucu.run;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "src/test/java/features/tableCommit.feature",
		plugin={"pretty", 
				"html:target/cucumber", 
				"json:target/cucumber/cucumber.json", 
				"junit:target/junit"},
		tags = ("@tag1"),
		glue = {"steps"}
		)


public class Runner extends AbstractTestNGCucumberTests{
	private TestNGCucumberRunner testNGCucumberRunner;
}
