package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",
        tags = "@regression",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-html-report"})
public class RegressionRunner extends Hooks {

}
