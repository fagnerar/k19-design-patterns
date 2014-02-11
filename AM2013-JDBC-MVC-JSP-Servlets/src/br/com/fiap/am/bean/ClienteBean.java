package br.com.fiap.am.bean;

public class ClienteBean extends PessoaBean {
	
	private int cnpj;
	private String razaoSocial;
	private int inscricaoEstadual;
	private String email;
	private String senha;
	
	public ClienteBean() {}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public int getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(int inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
