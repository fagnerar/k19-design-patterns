package br.com.fiap.am.bean;

import java.util.List;

public class TipoCausaBean {
	
	private int cdCausa;
	private String descricao;
	private List<AdvogadoBean> advList;
	
	public TipoCausaBean() {}

	public int getCdCausa() {
		return cdCausa;
	}

	public void setCdCausa(int cdCausa) {
		this.cdCausa = cdCausa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<AdvogadoBean> getAdvList() {
		return advList;
	}

	public void setAdvList(List<AdvogadoBean> advList) {
		this.advList = advList;
	}

}
