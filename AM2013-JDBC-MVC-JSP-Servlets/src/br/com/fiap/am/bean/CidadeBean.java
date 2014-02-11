package br.com.fiap.am.bean;

public class CidadeBean {
	
	private int codCidade;
	private EstadoBean codEstado;

	private String nome;
	
	public CidadeBean() {}
	
	public int getCodCidade() {
		return codCidade;
	}
	
	public void setCodCidade(int codCidade) {
		this.codCidade = codCidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public EstadoBean getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(EstadoBean codEstado) {
		this.codEstado = codEstado;
	}
	
}
