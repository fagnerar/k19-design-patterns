package br.com.fiap.am.bean;

public class BairroBean {
	
	private int codBairro;
	private CidadeBean codCidade;
	
	public BairroBean() {}

	public int getCodBairro() {
		return codBairro;
	}

	public void setCodBairro(int codBairro) {
		this.codBairro = codBairro;
	}

	public CidadeBean getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(CidadeBean codCidade) {
		this.codCidade = codCidade;
	}
	
}
