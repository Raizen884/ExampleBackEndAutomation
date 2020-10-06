package br.com.automacao.rest.hooks;

import org.apache.log4j.Logger;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	final static Logger logger = Logger.getLogger(Hooks.class.getName());
	
//	DataTest data;
//	
//	public Hooks(DataTest data) {
//		this.data = data;
//	}
	
	@Before
	public void init(Scenario scenario) {
		logger.info("------------------------------------------------------------------------------------------------------------------------------------------");
		logger.info("Cenario: ".concat(scenario.getName()));
	}
	
	@After
	public void afterScenarioExecution(Scenario scenario) {
		logger.info("------------------------------------------------------------------------------------------------------------------------------------------");
		logger.info("Fim do Cenario: '".concat(scenario.getName()).concat("' teve status ") + (scenario.getStatus().toString().toUpperCase()));
		logger.info("------------------------------------------------------------------------------------------------------------------------------------------\n\n");

	}
	
}
