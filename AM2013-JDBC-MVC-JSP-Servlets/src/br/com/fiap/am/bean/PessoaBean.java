package br.com.fiap.am.bean;

public abstract class PessoaBean {
	
	private int codigo;
	private String nome;
	
	public PessoaBean() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
