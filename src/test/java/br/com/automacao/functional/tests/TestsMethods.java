package br.com.automacao.functional.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.Reisen.FrameworkAPI.API.APIMethods;
import com.Reisen.FrameworkAPI.API.BaseFramework;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestsMethods {

	public PrintStream requestCapture;
	public PrintStream responseCapture;
	private BaseFramework framework;

	@Before
	public void beforeTest() throws IOException {
		framework = new BaseFramework();
		String url = "http://httpbin.org";
		framework.getDataBase().setUrl(url);
		String endPoint = "post";
		framework.getDataBase().setEndPoint(endPoint);
	}

	@Test
	public void testPost() {
		APIMethods methodTest = new APIMethods(framework);
		String body = "{}";

		methodTest.postBody(body);

		String jsonResponse = "{\r\n" + "  \"args\": {}, \r\n" + "  \"data\": \"{}\", \r\n" + "  \"files\": {}, \r\n"
				+ "  \"form\": {}, \r\n" + "  \"headers\": {\r\n" + "    \"Accept\": \"*/*\", \r\n"
				+ "    \"Accept-Encoding\": \"gzip,deflate\", \r\n" + "    \"Content-Length\": \"2\", \r\n"
				+ "    \"Content-Type\": \"application/json; charset=UTF-8\", \r\n"
				+ "    \"Host\": \"httpbin.org\", \r\n"
				+ "    \"User-Agent\": \"Apache-HttpClient/4.5.3 (Java/1.8.0_181)\"\r\n" + "  }, \r\n"
				+ "  \"json\": {}, \r\n" + "  \"origin\": \"200.206.39.170, 200.206.39.170\", \r\n"
				+ "  \"url\": \"https://httpbin.org/post\"\r\n" + "}\r\n";
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(jsonResponse);
		JsonObject jsonResponseJ = element.getAsJsonObject();

		String jsonActualResponse = framework.getTestResults().getLastResult().getBody();
		JsonParser parserA = new JsonParser();
		JsonElement elementA = parserA.parse(jsonActualResponse);
		JsonObject jsonResponseJA = elementA.getAsJsonObject();

		assertEquals(jsonResponseJ.toString(), jsonResponseJA.toString());

	}
}
