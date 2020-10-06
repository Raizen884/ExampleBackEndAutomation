package com.Reisen.FrameworkAPI.API;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;


public class TestLog {
	private PrintStream requestCapture;
	private PrintStream responseCapture;
	private StringWriter requestWrite;
	private StringWriter responseWrite;
	
	
	public TestLog() {
		StringWriter requestWrite = new StringWriter();
		setRequestCapture(new PrintStream(new WriterOutputStream(requestWrite, "UTF-8"), true));
		setRequestWrite(requestWrite);
		StringWriter responseWrite = new StringWriter();
		setResponseCapture(new PrintStream(new WriterOutputStream(responseWrite, "UTF-8"), true));
		setResponseWrite(responseWrite);
	}

	public PrintStream getRequestCapture() {
		return requestCapture;
	}

	public void setRequestCapture(PrintStream requestCapture) {
		this.requestCapture = requestCapture;
	}

	public PrintStream getResponseCapture() {
		return responseCapture;
	}

	public void setResponseCapture(PrintStream responseCapture) {
		this.responseCapture = responseCapture;
	}

	public StringWriter getRequestWrite() {
		return requestWrite;
	}

	public void setRequestWrite(StringWriter requestWrite) {
		this.requestWrite = requestWrite;
	}

	public StringWriter getResponseWrite() {
		return responseWrite;
	}

	public void setResponseWrite(StringWriter responseWrite) {
		this.responseWrite = responseWrite;
	}
}
