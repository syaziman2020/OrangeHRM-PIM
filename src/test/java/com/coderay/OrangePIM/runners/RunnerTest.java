package com.coderay.OrangePIM.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("features")
@ConfigurationParameter(key = "cucumber.glue", value = "com.coderay.OrangePIM.stepDefinitions, com.coderay.OrangePIM.hooks")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:target/cucumber-reports/cucumber-reports.html,"
		+ "json:target/cucumber-reports/cucumber-reports.json,"
		+ "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
@ConfigurationParameter(key = "cucumber.publish.quiet", value = "true")
@ConfigurationParameter(
	    key = "cucumber.filter.tags", 
	    value = ""
	)
public class RunnerTest {
}