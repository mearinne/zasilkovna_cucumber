
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources",
        glue={"step_definitions","web_mapping"},
        plugin={"html:target/cucumber-html-report", "json:target/cucumber.json",

                "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", "junit:target/cucumber-"
                +"results.xml"},

                dryRun = false,
        monochrome = true,
        tags={"@Smoker"}
)
public class launcher {

}
