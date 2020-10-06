package br.com.automacao.functional.tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.Reisen.FrameworkAPI.API.BaseFramework;

public class TestFiles {
	private BaseFramework framework;

	@Before
	public void beforeTest() throws IOException
	{
		framework = new BaseFramework();
	}
	
	@Test
	public void testSingleYamlData() throws Exception
	{
		String actual = "";
		actual = framework.getDataBase().getAsString("proposal.yaml", "Proposal", "documentType");
		Assert.assertEquals(String.valueOf("F"), actual);
	}
}
