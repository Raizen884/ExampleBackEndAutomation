package com.Reisen.FrameworkAPI.API;

import java.util.ArrayList;

public class TestResults {
	private ArrayList<ResultDescription> resultDescription;

	public TestResults() {
		resultDescription = new ArrayList<ResultDescription>();
	}

	public ArrayList<ResultDescription> getResultDescriptions() {
		return this.resultDescription;
	}

	public ResultDescription getLastResult() {
		return this.resultDescription.get(this.resultDescription.size() - 1);
	}

	public void addResultDescription(ResultDescription resultDescription) {
		this.resultDescription.add(resultDescription);
	}
}
