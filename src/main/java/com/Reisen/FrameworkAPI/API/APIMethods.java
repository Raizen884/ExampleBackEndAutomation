package com.Reisen.FrameworkAPI.API;

import java.io.File;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class APIMethods {

	public RequestSpecification test;

	protected StringWriter requestWrite;
	protected PrintStream requestCapture;

	protected StringWriter responseWrite;
	protected PrintStream responseCapture;
	protected String endPoint;
	private String URL;

	protected BaseFramework framework;

	// --- Method Classes ---//
	private PostRequest postMethod;
	private PutRequest putMethod;
	private GetRequest getMethod;
	private DeleteRequest deleteMethod;

	public APIMethods() {
	}

	public APIMethods(BaseFramework framework) {
		this.framework = framework;
		setMethodVariables();
	}

	private void setMethodVariables() {
		postMethod = new PostRequest(framework);
		putMethod = new PutRequest(framework);
		getMethod = new GetRequest(framework);
		deleteMethod = new DeleteRequest(framework);
	}

	protected void setInitialVariables() {
		URL = this.framework.getDataBase().getUrl();
		endPoint = this.framework.getDataBase().getEndPoint();
		RestAssured.useRelaxedHTTPSValidation();
		requestCapture = this.framework.getTestlog().getRequestCapture();
		requestWrite = this.framework.getTestlog().getRequestWrite();
		responseCapture = this.framework.getTestlog().getResponseCapture();
		responseWrite = this.framework.getTestlog().getResponseWrite();
	}

	public RequestSpecification defineBaseURL() {
			RequestSpecification espc = new RequestSpecBuilder().setBaseUri(this.framework.getDataBase().getUrl()).build();
			return RestAssured.given().spec(espc);
		
	}

	public String getToken() {
		return "";
	}

	@Override
	public String toString() {
		return "\nRequest: \n" + ResultDescription.getIDescription().descricaoRequest + "\nResponse: \n"
				+ ResultDescription.getIDescription().descricaoResponse;
	}

	/*
	 * Inicio do bloco de chamadas de POST
	 */
	public void postQuery(String valor) {
		this.framework.getTestResults().addResultDescription(postMethod._postQuery(valor));
	}

	public void postQuery(String chave, String valor) {
		this.framework.getTestResults().addResultDescription(postMethod._postQuery(chave, valor));
	}

	public void postQuery(String chave, Object obj) {
		this.framework.getTestResults().addResultDescription(postMethod._postQuery(chave, obj));
	}

	public void postQuery(String chave, Map<?, ?> map) {
		this.framework.getTestResults().addResultDescription(postMethod._postQuery(chave, map));
	}

	public void postBody(String valor) {
		this.framework.getTestResults().addResultDescription(postMethod._postBody(valor));
	}

	public void postBody(String chave, String valor) {
		this.framework.getTestResults().addResultDescription(postMethod._postBody(chave, valor));
	}

	public void postBody(Object obj) {
		this.framework.getTestResults().addResultDescription(postMethod._postBody(obj));
	}

	public void postBody(File file) {
		this.framework.getTestResults().addResultDescription(postMethod._postBody(file));
	}

	/*
	 * Inicio do bloco de chamadas de GET
	 */
	public void getQuery(String valor) {
		this.framework.getTestResults().addResultDescription(getMethod._getQuery(valor));
	}

	public void getQuery(String chave, String valor) {
		this.framework.getTestResults().addResultDescription(getMethod._getQuery(chave, valor));
	}

	public void getQuery(String chave, Object obj) {
		this.framework.getTestResults().addResultDescription(getMethod._getQuery(chave, obj));
	}

	public void getQuery(String chave, Map<?, ?> map) {
		this.framework.getTestResults().addResultDescription(getMethod._getQuery(chave, map));
	}

	public void getBody(Map<String, ?> map) {
		this.framework.getTestResults().addResultDescription(getMethod._getBody(map));
	}

	public void getBody(String chave, String valor) {
		this.framework.getTestResults().addResultDescription(getMethod._getBody(chave, valor));
	}

	public void getBody(String valor) {
		this.framework.getTestResults().addResultDescription(getMethod._getBody(valor));
	}

	public void getBody(File file) {
		this.framework.getTestResults().addResultDescription(getMethod._getBody(file));
	}

	/*
	 * Inicio do bloco de chamadas de PUT
	 */
	public void putQuery(String valor) {
		this.framework.getTestResults().addResultDescription(putMethod._putQuery(valor));
	}

	public void putQuery(String chave, String valor) {
		this.framework.getTestResults().addResultDescription(putMethod._putQuery(chave, valor));
	}

	public void putQuery(String chave, Object obj) {
		this.framework.getTestResults().addResultDescription(putMethod._putQuery(chave, obj));
	}

	public void putQuery(String chave, Map<?, ?> map) {
		this.framework.getTestResults().addResultDescription(putMethod._putQuery(chave, map));
	}

	public void putBody(Map<?, ?> map) {
		this.framework.getTestResults().addResultDescription(putMethod._putBudy(map));
	}

	public void putBody(String value) {
		this.framework.getTestResults().addResultDescription(putMethod._putBudy(value));
	}

	public void putBody(Object obj) {
		this.framework.getTestResults().addResultDescription(putMethod._putBudy(obj));
	}

	public void putBody(String chave, String valor) {
		this.framework.getTestResults().addResultDescription(putMethod._putBudy(chave, valor));
	}

	public void putBody(File file) {
		this.framework.getTestResults().addResultDescription(putMethod._putBudy(file));
	}

	/*
	 * Inicio do bloco de chamadas de DELETE
	 */
	public void deleteQuery(String valor) {
		this.framework.getTestResults().addResultDescription(deleteMethod._deleteQuery(valor));
	}

	public void deleteQuery(String valor, Map<String, ?> map) {
		this.framework.getTestResults().addResultDescription(deleteMethod._deleteQuery(valor, map));
	}

	public void deleteQuery(String value, Object obj) {
		this.framework.getTestResults().addResultDescription(deleteMethod._deleteQuery(value, obj));
	}

	public void deleteQuery(String chave, String valor) {
		this.framework.getTestResults().addResultDescription(deleteMethod._deleteQuery(chave, valor));
	}

	public void deleteBody(Object obj) {
		this.framework.getTestResults().addResultDescription(deleteMethod._deleteBody(obj));
	}

	public void deleteBody(File file) {
		this.framework.getTestResults().addResultDescription(deleteMethod._deleteBody(file));
	}

	public void deleteBody(String value) {
		this.framework.getTestResults().addResultDescription(deleteMethod._deleteBody(value));
	}

	public void deleteBody(String chave, String value) {
		this.framework.getTestResults().addResultDescription(deleteMethod._deleteBody(chave, value));
	}

}
