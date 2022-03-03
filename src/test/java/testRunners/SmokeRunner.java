package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/features/v1",
        glue = {"v1.stepDefinitions"},
        tags = "@SmokeTest")


public class SmokeRunner {

}
