package definitions;


/* @CucumberOptions(plugin = {"progress", "html:target/cucumber-html-report"},
				features = "src/test/resources",
				tags = "@wip") */

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "progress", "html:target/cucumber-html-report" },
				features = "src/test/resources",
		dryRun = true,
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = "definitions",
tags = "")
public class RunCukesTestBDD extends AbstractTestNGCucumberTests {
}
