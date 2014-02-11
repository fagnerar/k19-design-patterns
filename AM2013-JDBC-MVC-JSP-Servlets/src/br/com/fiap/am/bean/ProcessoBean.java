package br.com.fiap.am.bean;

import java.util.Date;

public class ProcessoBean {
	
	private int nroProcesso;
	private Date dtAbertura;
	private Date dtFechto;
	private String descricao;
	private String obs;
	private int diaVencto;
	private boolean resultado;
	private boolean situacao;
	private ClienteBean cliente;
	private ForumBean forum;
	private AdvogadoBean advogado;
	private TipoCausaBean tipoCausa;
	
	public ProcessoBean() {}

	public int getNroProcesso() {
		return nroProcesso;
	}

	public void setNroProcesso(int nroProcesso) {
		this.nroProcesso = nroProcesso;
	}

	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtFechto() {
		return dtFechto;
	}

	public void setDtFechto(Date dtFechto) {
		this.dtFechto = dtFechto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public int getDiaVencto() {
		return diaVencto;
	}

	public void setDiaVencto(int diaVencto) {
		this.diaVencto = diaVencto;
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

	public ForumBean getForum() {
		return forum;
	}

	public void setForum(ForumBean forum) {
		this.forum = forum;
	}

	public AdvogadoBean getAdvogado() {
		return advogado;
	}

	public void setAdvogado(AdvogadoBean advogado) {
		this.advogado = advogado;
	}

	public TipoCausaBean getTipoCausa() {
		return tipoCausa;
	}

	public void setTipoCausa(TipoCausaBean tipoCausa) {
		this.tipoCausa = tipoCausa;
	}
	
	

}
