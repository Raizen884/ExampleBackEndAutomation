package com.Reisen.FrameworkAPI.CarregarMassa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

/**
 *
 * Classe que permite a leitura de massa de dados de arquivos .yaml<BR>
 *
 */
public class YamlFileLoader {
	private String result = "\n";
	private Map<?, ?> mapAux;
	private String fileName = "";

	public YamlFileLoader(String path) throws FileNotFoundException {
		File file = new File(path);
		InputStream input = new FileInputStream(file);
		Yaml yaml = new Yaml();
		mapAux = (Map<?, ?>) yaml.load(input);
		fileName = file.getName();
	}

	/**
	 * Realiza a leitura de arquivos .yaml e retorna um determinado valor<BR>
	 * 
	 * @param path
	 *            Caminho do arquivo
	 * @param param
	 *            titulo e sub-titulo que deseja captura no arquivo yaml
	 * @return
	 * @throws Exception
	 */
	public Object getAttribute(String... param) throws Exception {

		if (mapAux == null) {
			throw new Exception(String.format("A massa de dados não foi localizada no arquivo %s", fileName));
		}

		int cont;

		for (cont = 0; cont < (param.length - 1); cont++) {
			mapAux = (Map<?, ?>) mapAux.get(param[cont]);
		}

		if (Character.isDigit(param[cont].charAt(0))) {
			return mapAux.get(Integer.parseInt(param[cont]));
		}

		return mapAux.get(param[cont]);
	}

	public String getContent(String path) throws Exception {
		List<String> chave = new ArrayList<String>();
		List<String> valor = new ArrayList<String>();
		Yaml yaml = new Yaml();

		try {

			InputStream ios = new FileInputStream(new File(path));

			@SuppressWarnings("unchecked")
			LinkedHashMap<String, Object> retornoYML = (LinkedHashMap<String, Object>) yaml.load(ios);

			for (Object nome : retornoYML.keySet()) {
				chave.add(nome.toString());
				valor.add(retornoYML.get(nome).toString());
			}
			for (int i = 0; i < chave.size(); i++) {
				result = result + chave.get(i) + "\n" + valor.get(i).replace(",", "\n").replaceAll("}", "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}