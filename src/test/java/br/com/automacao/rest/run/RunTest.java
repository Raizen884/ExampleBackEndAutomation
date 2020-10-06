package br.com.automacao.rest.run;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
//overviewReport = true,
//outputFolder = "target")
@CucumberOptions(
		snippets = SnippetType.CAMELCASE,
		plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" },
        features = { "features/" },
        glue = { "br.com.automacao" })
//      tags = {"@GetProposalById"})
public class RunTest {
    public RunTest() {
    }
}