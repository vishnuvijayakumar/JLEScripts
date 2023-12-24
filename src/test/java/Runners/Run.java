package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinitions"}, plugin = {"pretty"
        , "html:target/Reports/report.html"},
        tags = "@test"
)
public class Run extends AbstractTestNGCucumberTests {

}


