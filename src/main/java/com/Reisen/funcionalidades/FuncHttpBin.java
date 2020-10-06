package com.Reisen.funcionalidades;

import com.Reisen.FrameworkAPI.API.APIMethods;
import com.Reisen.FrameworkAPI.API.BaseFramework;

import br.com.automacao.functional.tests.PojoTest;

public class FuncHttpBin {

	private BaseFramework framework;
	private PojoTest pojoTest;
	private APIMethods apiMethods;

	public FuncHttpBin(BaseFramework framework) {
		this.framework = framework;
		this.apiMethods = new APIMethods(framework);
		
	}

	public void createValidDataPost() {
		pojoTest = new PojoTest();
		pojoTest.setTestKey("testKey");
	}

	public void post() {
		this.apiMethods.postBody(pojoTest);
	}

	public void get() {
		this.apiMethods.getBody("");
	}
	
	public String getResponse() {
		return this.framework.getTestResults().getLastResult().descricaoResponse;
	}

	public Integer getStatusCode() {
		return this.framework.getTestResults().getLastResult().getStatusCode();
	}
	
	public void defineBaseURL() {
		this.apiMethods.defineBaseURL();
	}

}
