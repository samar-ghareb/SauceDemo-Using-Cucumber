package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/home/sara/IdeaProjects/Q-Pros/src/test/java/automationtesting",
        glue = {"automationtesting"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}
