package br.com.fiap.am.bean;

public class EstadoBean {
	
	private int codEstado;
	private String nome;
	private String sigla;

	public EstadoBean() {}

	public int getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
