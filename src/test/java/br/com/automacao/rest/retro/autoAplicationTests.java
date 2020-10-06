package br.com.automacao.rest.retro;

import org.junit.Test;

public class autoAplicationTests {
	
	
	public static void main( String[] args ) throws Exception
	{
		autoAplicationTests test = new autoAplicationTests();
		test.carregarEndPoint();
	}
	
	@Test	
	public void carregarYamlPathCompleto() throws Exception { 
		//LoadTestDataOld teste = new LoadTestDataOld();
		//System.out.println("CaminhoCompleto: \n" + teste.getStringYAML("C:\\Users\\Inmetrics\\git\\frameworkapiressed\\resources\\massa_dados\\authentication.yaml"));
		//System.out.println("CaminhoCompleto: \n" + teste.getStringYAML("C:/Users/Inmetrics/git/frameworkapiressed/resources/massa_dados/authentication.yaml"));
	}
	
	@Test 
	public void carregaYamlOnlyFullName() throws Exception {
		//LoadTestDataOld teste = new LoadTestDataOld();
		//System.out.println("Apenas Full Name: \n" + teste.getStringYAML("/authentication.yaml"));
		//System.out.println("Apenas Full Name: \n" + teste.getStringYAML("\\authentication.yaml"));
	}
	
	@Test 
	public void carregaYamlOnlyName() throws Exception {
		//LoadTestDataOld teste = new LoadTestDataOld();
		//System.out.println("Apenas Nome: \n" + teste.getStringYAML("/authentication"));
		//System.out.println("Apenas Nome: \n" + teste.getStringYAML("\\authentication"));
	}
	
	@Test
	public void capturarValorURL() {
		//LoadTestDataOld teste = new LoadTestDataOld("base.url");
		//System.out.println(teste.URL);
	}
	
	@Test
	public void carregarEndPoint() {
		//LoadTestDataOld teste = new LoadTestDataOld("base.url", "endpoint.unlocks");
		//System.out.println(teste.URL);
		//System.out.println(teste.endPoint);
	}

}
