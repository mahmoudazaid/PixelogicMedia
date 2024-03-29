package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",
        tags = "not @manual",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-html-report"})
public class TestRunner extends Hooks {

}
