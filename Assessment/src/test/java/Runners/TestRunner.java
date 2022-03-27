package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features="src/main/resources/Features",
        glue= {"com/StepDefinations"},
        tags = "@test4",
        monochrome = true,
        plugin = { "pretty","html:target/Report/cucumber-reports.html", "json:target/Report/cucumber-report.json",
                 "junit:target/Report/cucumber-reports.xml"}
              )
@RunWith(Cucumber.class)

public class TestRunner  {


}
