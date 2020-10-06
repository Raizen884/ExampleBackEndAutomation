package com.Reisen.FrameworkAPI.API;


import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;

import io.restassured.response.ValidatableResponse;

public class ResultDescription {

	final static Logger logger = Logger.getLogger(ResultDescription.class.getName());

	public String descricaoRequest;
	public String descricaoResponse;
	public ValidatableResponse validation;

	static ResultDescription instance = null;

	public ResultDescription() {
		super();
	}

	public static ResultDescription getIDescription() {
		if (instance == null){
			instance = new ResultDescription();
		}
		return instance;
	}

	public ResultDescription(String descricaoRequest, String descricaoResponse, ValidatableResponse validacao) {
		super();
		this.descricaoRequest = descricaoRequest;
		this.descricaoResponse = descricaoResponse;

		logger.info("Request".concat("\n").concat(descricaoRequest));
		logger.info("Response".concat("\n").concat(descricaoResponse));

		this.validation = validacao;
	}

	public void compararMensagem(String mensagemEsperada, String campo) {
		try {
			assertEquals("Não apresentou valor correto", mensagemEsperada, validation.extract().path(campo));
		}catch (Exception e) {
			System.out.println("Erro ao encontrar mensagem esperada.");
		}
	}
	
	public void compararMensagem(String mensagemEsperada, String campo, String... values ) {
		try {
			assertEquals("Não apresentou valor correto", mensagemEsperada, validation.extract().path(campo, values));
		}catch (Exception e) {
			System.out.println("Erro ao encontrar mensagem esperada.");
		}
	}
	
	public void compararBody(String value) {
		try {
			assertEquals("Não apresentou valor correto", validation.extract().body().asString(), value);
		}catch (Exception e) {
			System.out.println("Erro ao encontrar mensagem esperada.");
		}
	}
	
	public void compararStatusCode(int statusCode) {
		validation.statusCode(statusCode);
	}
	
	public void compararStatusCode(String statusCode) {
		Integer code = Integer.parseInt(statusCode);
		validation.statusCode(code);
	}

	public String getValidationSring() {
		return (validation.extract().toString());
	}
	
	public String getValue(String campo) {
		return validation.extract().path(campo);
	}

	public String getBody() {
		return validation.extract().body().asString();
	}
	
	public String getHeaderValue(String value) {
		return validation.extract().header(value);
	}
	
	public String getContentType() {
		return validation.extract().contentType();
	}
	
	public String getStatusLine() {
		return validation.extract().statusLine();
	}
	
	public int getStatusCode() {
		return validation.extract().statusCode();
	}
	
	public String getSessionID() {
		return validation.extract().sessionId();
	}
	
	








}