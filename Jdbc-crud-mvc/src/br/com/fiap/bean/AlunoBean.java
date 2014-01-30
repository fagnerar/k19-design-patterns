package br.com.fiap.bean;

public class AlunoBean {
	
	private int idAluno;
	private int rm;
	private String nome;
	private String turma;
	private int ano;
	private boolean ativo;
	
	public AlunoBean() { }
	
	public AlunoBean(int rm, String nome, String turma, int ano, boolean ativo) {
		this.rm = rm;
		this.nome = nome;
		this.turma = turma;
		this.ano = ano;
		this.ativo = ativo;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	

}
