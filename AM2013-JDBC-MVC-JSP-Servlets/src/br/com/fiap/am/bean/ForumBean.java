package br.com.fiap.am.bean;

public class ForumBean extends PessoaBean {
	
	private int codForum;
	private String descricao;
	
	public ForumBean() {}

	public int getCodForum() {
		return codForum;
	}

	public void setCodForum(int codForum) {
		this.codForum = codForum;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
