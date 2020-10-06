package com.Reisen.massaDados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.Reisen.FrameworkAPI.CarregarMassa.PropertiesLoader;
import com.Reisen.FrameworkAPI.CarregarMassa.YamlFileLoader;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoadTestData {
	private Map<String, YamlFileLoader> yaml = new HashMap<String, YamlFileLoader>();
	private Map<String, Object> testData = new HashMap<String, Object>();
	private String url;
	private String endPoint;
	private PropertiesLoader properties;

	public LoadTestData() throws IOException {
		loadAllYamlFiles();
		loadProperties();
		loadUrl();
	}

	private void loadUrl() {
		url = properties.getValue("base.url");
	}

	private void loadProperties() throws IOException {
		properties = new PropertiesLoader("/application.properties");
	}

	private void loadAllYamlFiles() throws FileNotFoundException {
		loadYamlFiles();
	}

	public void setData(String key, Object value) {
		testData.put(key, value);
	}

	public Map<String, Object> getData() {
		return this.testData;
	}

	public List<String> readFromArray(String key) {
		return null;

	}

	public String getAsString(String fileName, String... params) throws Exception {
		return String.valueOf(getYamlAttribute(fileName, params));
	}

	public String getAsString(String key) {
		return String.valueOf(testData.get(key));

	}

	public Integer getAsInteger(String key) {
		return (Integer) testData.get(key);

	}

	public Double getAsDouble(String key) {
		return new BigDecimal((Double) testData.get(key)).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
	}

	public Long getAsLong(String key) {
		return (Long) testData.get(key);
	}

	public String[] getAsStringArray(String key) {
		return (String[]) testData.get(key);
	}

	public Integer[] getAsIntegerArray(String key) {
		return (Integer[]) testData.get(key);
	}

	public Double[] getAsDoubleArray(String key) {
		return (Double[]) testData.get(key);
	}

	public Long[] getAsLongArray(String key) {
		return (Long[]) testData.get(key);
	}

	public void setData(JsonObject json) {

		Set<Map.Entry<String, JsonElement>> entries = json.entrySet();// will return members of your object
		for (Map.Entry<String, JsonElement> entry : entries) {
			this.setData(entry.getKey(), entry.getValue().getAsString());
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getFullUrl() {
		return this.url + "/" + this.endPoint;
	}

	public void loadYamlFiles() throws FileNotFoundException {
		String basePath = System.getProperty("user.dir") + "\\resources\\massa_dados";
		File folder = new File(basePath);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				yaml.put(listOfFiles[i].getName(), new YamlFileLoader(listOfFiles[i].getAbsolutePath()));
			}
		}

	}

	public Object getYamlAttribute(String fileName, String... params) throws Exception {
		return yaml.get(fileName).getAttribute(params);
	}

}
