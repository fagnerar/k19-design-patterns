package br.com.fiap.am.bean;

public class PessoaEndeBean {
	
	private int codPessoaEnde;
	private int numCep;
	private PessoaBean codPessoa;
	private int numEnde;
	private String complementoEnde;
	
	public PessoaEndeBean() {}

	public int getCodPessoaEnde() {
		return codPessoaEnde;
	}

	public void setCodPessoaEnde(int codPessoaEnde) {
		this.codPessoaEnde = codPessoaEnde;
	}

	public int getNumCep() {
		return numCep;
	}

	public void setNumCep(int numCep) {
		this.numCep = numCep;
	}

	public PessoaBean getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(PessoaBean codPessoa) {
		this.codPessoa = codPessoa;
	}

	public int getNumEnde() {
		return numEnde;
	}

	public void setNumEnde(int numEnde) {
		this.numEnde = numEnde;
	}

	public String getComplementoEnde() {
		return complementoEnde;
	}

	public void setComplementoEnde(String complementoEnde) {
		this.complementoEnde = complementoEnde;
	}

}
