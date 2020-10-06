package br.com.automacao.rest.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Reisen.FrameworkAPI.CarregarMassa.PropertiesLoader;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Report {
		
	public void newReport() throws IOException {
		
		File reportOutputDirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("./target/report.json");
		PropertiesLoader properties = new PropertiesLoader("application.properties");
		String buildNumber = "1.0.0";
		String projectName = properties.getValue("name.project");
		String ambiente = properties.getValue("ambiente");
		boolean runWithJenkins = false;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);

		configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);
		
		configuration.addClassifications("Sigla", "RL7");
		configuration.addClassifications("Ambiente", ambiente);
		configuration.addClassifications("Branch", "release/1.0");
		
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();

	}

}
