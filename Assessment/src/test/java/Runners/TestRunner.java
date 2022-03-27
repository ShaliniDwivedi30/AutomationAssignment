package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//use the tags which are mentioned in the feature file as per the scenarios
@CucumberOptions(features="src/main/resources/Features",
        glue= {"com/StepDefinations"},
        tags = "@Regression",
        monochrome = true,
        plugin = { "pretty","html:target/Report/tescasereport.html", "json:target/Report/testcasereport.json",
                 "junit:target/Report/cucumber-reports.xml"}
              )
@RunWith(Cucumber.class)

public class TestRunner  {


}
