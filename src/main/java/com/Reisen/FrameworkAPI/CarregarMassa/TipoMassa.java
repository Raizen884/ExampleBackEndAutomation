package com.Reisen.FrameworkAPI.CarregarMassa;

@Deprecated
public enum TipoMassa {


	YAML (".yaml"),
	JSON (".json"),
	XML (".xml");

	private String opcao;

	private TipoMassa(String opcao) {
		this.opcao = opcao;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}


	public TipoMassa carregarMasa(String base, String point) {
		//url = carregarLinha(base);
		//endPoint  = carregarLinha(point);
		return this;
	}

	public TipoMassa carregarMasa(String base, String point, TipoMassa tipo) throws Exception {
		try {
			if (tipo.equals(TipoMassa.YAML)) {
				return carregarMasa(base, point);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return null;
	}



}
