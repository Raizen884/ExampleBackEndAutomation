package com.Reisen.FrameworkAPI.API;

import java.io.File;
import java.util.Map;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class PutRequest extends APIMethods{


	public PutRequest(BaseFramework framework) {
		this.framework = framework;
		setInitialVariables();
		test = defineBaseURL();
	}

	public ResultDescription _putQuery(String valor) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(valor)
				.when()
				.put(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _putQuery(String chave, String valor) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, valor)
				.when()
				.put(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _putQuery(String chave, Map<?,?> map) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, map)
				.when()
				.put(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _putQuery(String chave, Object obj) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, obj)
				.when()
				.put(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _putBudy(Object obj) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(obj)
				.when()
				.put(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _putBudy(String valor) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(valor)
				.when()
				.put(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _putBudy(String chave, String valor) {
		String body = "{\"" + chave + "\":\"" + valor + "\"}";
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(body)
				.when()
				.put(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _putBudy(Map<String,?> map) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				.put(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _putBudy(File file) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(file)
				.when()
				.put(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	
}
