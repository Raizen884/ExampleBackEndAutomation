package com.Reisen.FrameworkAPI.API;

import java.io.File;
import java.util.Map;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class DeleteRequest extends APIMethods{

	public DeleteRequest(BaseFramework framework) {
		this.framework = framework;
		setInitialVariables();
		test = defineBaseURL();
	}	
	
	public ResultDescription _deleteQuery(String valor) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(valor)
				.when()
				.delete(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _deleteQuery(String chave, String valor) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, valor)
				.when()
				.delete(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _deleteQuery(String chave, Map<?,?> map) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, map)
				.when()
				.delete(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _deleteQuery(String chave, Object obj) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, obj)
				.when()
				.delete(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}


	public ResultDescription _deleteBody(Object obj) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(obj)
				.when()
				.delete(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	public ResultDescription _deleteBody(File file) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(file)
				.when()
				.delete(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _deleteBody(String value) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(value)
				.when()
				.delete(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _deleteBody(String chave, String valor) {
		String body = "{\"" + chave + "\":\"" + valor + "\"}";
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(body)
				.when()
				.delete(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	
	
}
