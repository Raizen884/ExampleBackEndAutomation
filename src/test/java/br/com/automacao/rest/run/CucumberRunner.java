package br.com.automacao.rest.run;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import br.com.automacao.rest.util.Report;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun = false,
		monochrome = true,
		strict = true,
		junit = "--step-notifications",
		plugin = {"pretty", "json:target/report.json"}, 
		snippets = SnippetType.CAMELCASE,
		features = {"features/"},
		glue = {"com.RedeLabs"},
		tags = {"@TestHttpBin"}
		)
public class CucumberRunner {
	@AfterClass
	public static void teardown() throws IOException {
		new Report().newReport();
	}

}
