package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "steps",
        plugin = { "pretty", "json:target/cucumber-reports/CucumberJson.json"},
        monochrome = true,
        tags = "@gorest",
        snippets = CucumberOptions.SnippetType.CAMELCASE, dryRun = false)
public class Runner {
}
