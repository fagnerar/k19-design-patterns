package br.com.fiap.am.bean;

import java.util.Date;

public class HistProcBean {

	private ProcessoBean numProcesso;
	private int codTaxa;
	private Date dataValidade;
	
	public HistProcBean() {}

	public ProcessoBean getNumProcesso() {
		return numProcesso;
	}

	public void setNumProcesso(ProcessoBean numProcesso) {
		this.numProcesso = numProcesso;
	}

	public int getCodTaxa() {
		return codTaxa;
	}

	public void setCodTaxa(int codTaxa) {
		this.codTaxa = codTaxa;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

}
