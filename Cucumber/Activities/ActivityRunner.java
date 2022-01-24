package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "C:\\Users\\002H57744\\Documents\\IBM FST\\Workspace\\SeleniumCucumberActivity\\src\\test\\resources\\Features", glue = {
//		"StepDefination" }, tags = "@activity3", plugin = { "pretty",
//				"html:target/cucumber-reports/reports" }, monochrome = true)

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "C:\\Users\\002H57744\\Documents\\IBM FST\\Workspace\\SeleniumCucumberActivity\\src\\test\\resources\\Features", glue = {
//		"StepDefination" }, tags = "@SmokeTest or @ConfirmAlert", plugin = { "pretty",
//				"html:target/cucumber-reports/reports" }, monochrome = true)

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "C:\\Users\\002H57744\\Documents\\IBM FST\\Workspace\\SeleniumCucumberActivity\\src\\test\\resources\\Features", glue = {
//		"StepDefination" }, tags = "@activity4", plugin = { "pretty",
//				"html:target/cucumber-reports/reports" }, monochrome = true)

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\002H57744\\Documents\\IBM FST\\Workspace\\SeleniumCucumberActivity\\src\\test\\resources\\Features", glue = {
		"StepDefination" }, tags = "@activity5", plugin = { "pretty",
				"html: target/cucumber-reports/reports" }, monochrome = true)

public class ActivityRunner {
	// empty
}