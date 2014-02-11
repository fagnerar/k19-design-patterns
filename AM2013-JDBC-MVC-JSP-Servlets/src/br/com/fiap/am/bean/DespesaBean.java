package br.com.fiap.am.bean;

import java.util.Date;

public class DespesaBean {
	
	private int cdDespesa;
	private TipoDespesaBean tipoDespesa;
	private ProcessoBean processo;
	private Date dataDespesa;
	private double valorDespesa;
	private String obs;
	
	public DespesaBean() {}

	public int getCdDespesa() {
		return cdDespesa;
	}

	public void setCdDespesa(int cdDespesa) {
		this.cdDespesa = cdDespesa;
	}

	public TipoDespesaBean getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesaBean tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public ProcessoBean getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoBean processo) {
		this.processo = processo;
	}

	public Date getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public double getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
