package definitions;


/* @CucumberOptions(plugin = {"progress", "html:target/cucumber-html-report"},
				features = "src/test/resources",
				tags = "@wip") */

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "progress", "html:target/cucumber-html-report" },
				features = "src/test/resources",
				tags = "@fundTransferTest")
public class RunCukesTestBDD extends AbstractTestNGCucumberTests {
}
