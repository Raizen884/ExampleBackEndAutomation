package br.com.automacao.functional.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.Reisen.FrameworkAPI.API.BaseFramework;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestsData {
	BaseFramework framework;

	@Before
	public void beforeTest() throws IOException {
		framework = new BaseFramework();
	}

	@Test
	public void testGetStringData() {
		String key = "testKey";
		String value = "testValue";
		this.framework.getDataBase().setData(key, value);
		assertEquals(value, this.framework.getDataBase().getAsString(key));
	}

	@Test
	public void testGetIntegerData() {
		String key = "testKey";
		Integer value = 1234;
		this.framework.getDataBase().setData(key, value);
		assertEquals(value, this.framework.getDataBase().getAsInteger(key));
	}

	@Test
	public void testGetDoubleData() {
		String key = "testKey";
		Double value = 1234.32;
		this.framework.getDataBase().setData(key, value);
		assertEquals(value, this.framework.getDataBase().getAsDouble(key));
	}

	@Test
	public void testGetLongData() {
		String key = "testKey";
		Long value = 12421321321363L;
		this.framework.getDataBase().setData(key, value);
		assertEquals(value, this.framework.getDataBase().getAsLong(key));

	}

	@Test
	public void testGetStringListData() {
		String key = "testKey";
		String[] value = { "test1", "test2" };
		this.framework.getDataBase().setData(key, value);
		assertArrayEquals(value, this.framework.getDataBase().getAsStringArray(key));
	}

	@Test
	public void testGetIntegerListData() {
		String key = "testKey";
		Integer[] value = { 456, 123 };
		this.framework.getDataBase().setData(key, value);
		assertArrayEquals(value, this.framework.getDataBase().getAsIntegerArray(key));
	}

	@Test
	public void testGetDoubleListData() {
		String key = "testKey";
		Double[] value = { 10.23, 18.3214 };
		this.framework.getDataBase().setData(key, value);
		assertArrayEquals(value, this.framework.getDataBase().getAsDoubleArray(key));
	}

	@Test
	public void testGetLongListData() {
		String key = "testKey";
		Long[] value = { 453213213216L, 123213213123L };
		this.framework.getDataBase().setData(key, value);
		assertArrayEquals(value, this.framework.getDataBase().getAsLongArray(key));
	}

	@Test
	public void testSetMultipleDatas() {
		String key = "testKey";
		String value = "testValue";
		String key2 = "testKey2";
		String[] value2 = { "test1", "test2" };
		this.framework.getDataBase().setData(key, value);
		this.framework.getDataBase().setData(key2, value2);
		assertEquals(value, this.framework.getDataBase().getAsString(key));
		assertArrayEquals(value2, this.framework.getDataBase().getAsStringArray(key2));
	}
	
	@Test
	public void testSetJson()
	{
		String yourJson = "{'testKey' : 'testValue'}";
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(yourJson);
		JsonObject obj = element.getAsJsonObject();
		this.framework.getDataBase().setData(obj);
		assertEquals(String.valueOf("testValue"), this.framework.getDataBase().getAsString("testKey"));
	}

	@Test
	public void testgetURL()
	{
		String url = "http://httpbin.org";
		this.framework.getDataBase().setUrl(url);
		assertEquals(url, this.framework.getDataBase().getUrl());
	}
	
	@Test
	public void testgetEndpoint()
	{
		String endPoint = "post";
		this.framework.getDataBase().setEndPoint(endPoint);
		assertEquals(endPoint, this.framework.getDataBase().getEndPoint());
	}
	
	@Test
	public void testgetFullUrl()
	{
		String url = "http://httpbin.org";
		this.framework.getDataBase().setUrl(url);
		String endPoint = "post";
		this.framework.getDataBase().setEndPoint(endPoint);
		assertEquals(url + "/" + endPoint, this.framework.getDataBase().getFullUrl());
	}
	
}
