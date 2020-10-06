package com.Reisen.FrameworkAPI.API;

import java.io.File;
import java.util.Map;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class PostRequest extends APIMethods {

	public PostRequest(BaseFramework framework) {
		this.framework = framework;
		setInitialVariables();
		test = defineBaseURL();
	}

	
	public ResultDescription _postQuery(String valor) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(valor)
				.when()
				.post(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _postQuery(String chave, String valor) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, valor)
				.when()
				.post(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _postQuery(String chave, Map<?,?> map) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, map)
				.when()
				.post(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _postQuery(String chave, Object obj) {
		ValidatableResponse validation = 
				this.test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.queryParam(chave, obj)
				.when()
				.post(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	


	public ResultDescription _postBody(String request) {
		ValidatableResponse validation = test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(request)
				.when()
				.post(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);

	}
	public ResultDescription _postBody(String chave, String valor) {
		String body = "{\"" + chave + "\":\"" + valor + "\"}";
		ValidatableResponse validation = test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(body)
				.when()
				.post(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);
	}
	
	public ResultDescription _postBody(Object request) {
		ValidatableResponse validation = test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(request)
				.when()
				.post(this.framework.getDataBase().getEndPoint())
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);

	}
	
	public ResultDescription _postBody(File request) {
		ValidatableResponse validation = test
				.filter(new RequestLoggingFilter(this.requestCapture))
				.filter(new ResponseLoggingFilter(this.responseCapture))
				.contentType(ContentType.JSON)
				.body(request)
				.when()
				.post(endPoint)
				.then();

		return new ResultDescription(this.requestWrite.toString(), this.responseWrite.toString(), validation);

	}
}
