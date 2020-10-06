package com.Reisen.testSteps;

import org.junit.Assert;

import com.Reisen.FrameworkAPI.API.BaseFramework;
import com.Reisen.funcionalidades.FuncHttpBin;

import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;

public class TestSteps {
	private FuncHttpBin funcHttpBin;
	private BaseFramework framework;

	public TestSteps(BaseFramework framework) throws ClassNotFoundException {
		super();
		this.framework = framework;
		this.funcHttpBin = new FuncHttpBin(framework);
	}

	@Dado("^que tenho url válida$")
	public void queTenhoUrlValida() {
		this.framework.getDataBase().setUrl("https://api.trello.com");
		this.funcHttpBin.defineBaseURL();
	}

	@Dado("^que tenho o endpoint de get do trello$")
	public void queTenhoEndPointPost() {
		this.framework.getDataBase().setEndPoint("/1/actions/592f11060f95a3d3d46a987a");
	}

	@Dado("^que tenho dados válidos para httpBin$")
	public void queTenhoDadosValidosHttpBin() {
		funcHttpBin.createValidDataPost();
	}

	@Quando("^realizo um get$")
	public void realizoUmGet() {
		funcHttpBin.get();
	}

	@Então("recebo o response$")
	public void receboOResponse() {
		Assert.assertNotEquals("", funcHttpBin.getResponse());
	}
	
	@Então("valido se o status code é (\\d+)$")
	public void validoStatusCode(Integer code) {
		Assert.assertEquals(code, funcHttpBin.getStatusCode());
	}
	

}
