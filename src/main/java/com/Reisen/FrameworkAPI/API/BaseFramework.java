package com.Reisen.FrameworkAPI.API;

import java.io.IOException;

import com.Reisen.massaDados.LoadTestData;

public class BaseFramework {
	private LoadTestData dataBase;
	private TestLog testlog;
	private TestResults testResults;
	
	public BaseFramework() throws IOException
	{
		this.setDataBase(new LoadTestData());
		this.setTestlog(new TestLog());
		this.setTestResults(new TestResults());
	}

	public LoadTestData getDataBase() {
		return dataBase;
	}

	public void setDataBase(LoadTestData dataBase) {
		this.dataBase = dataBase;
	}

	public TestLog getTestlog() {
		return testlog;
	}

	public void setTestlog(TestLog testlog) {
		this.testlog = testlog;
	}

	public TestResults getTestResults() {
		return testResults;
	}

	public void setTestResults(TestResults testResults) {
		this.testResults = testResults;
	}
	
	
}
