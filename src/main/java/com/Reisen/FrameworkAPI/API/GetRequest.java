package com.Reisen.FrameworkAPI.API;

import java.io.File;
import java.util.Map;


import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class GetRequest extends APIMethods{
	
	public GetRequest(BaseFramework framework) {
		this.framework = framework;
		setInitialVariables();
		test = defineBaseURL();
	}


	public ResultDescription _getQuery(String valor) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(valor)
				.when()
				.get(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _getQuery(String chave, String valor) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, valor)
				.when()
				.get(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _getQuery(String chave, Map<?,?> map) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, map)
				.when()
				.get(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _getQuery(String chave, Object obj) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, obj)
				.when()
				.get(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}

	public ResultDescription _getBody(Map<String, ?> map) {
		ValidatableResponse validation = test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				.get(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _getBody(String chave, String valor) {
		String body = "{\"" + chave + "\":\"" + valor + "\"}";
		ValidatableResponse validation = test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(body)
				.when()
				.get(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _getBody(String valor) {
		ValidatableResponse validation = test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(valor)
				.when()
				.get(this.framework.getDataBase().getEndPoint())
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _getBody(Object obj) {
		ValidatableResponse validation = test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(obj)
				.when()
				.get(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	public ResultDescription _getBody(File file) {
		ValidatableResponse validation = test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(file)
				.when()
				.get(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
}
