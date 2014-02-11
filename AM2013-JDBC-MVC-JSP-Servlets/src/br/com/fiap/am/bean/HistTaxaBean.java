package br.com.fiap.am.bean;

import java.util.Date;

public class HistTaxaBean {
	
	private int codTaxa;
	private Date dataVigencia;
	private double valorTaxaJuros;
	private double valorMoraDiaria;
	
	public HistTaxaBean() {}

	public int getCodTaxa() {
		return codTaxa;
	}

	public void setCodTaxa(int codTaxa) {
		this.codTaxa = codTaxa;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public double getValorTaxaJuros() {
		return valorTaxaJuros;
	}

	public void setValorTaxaJuros(double valorTaxaJuros) {
		this.valorTaxaJuros = valorTaxaJuros;
	}

	public double getValorMoraDiaria() {
		return valorMoraDiaria;
	}

	public void setValorMoraDiaria(double valorMoraDiaria) {
		this.valorMoraDiaria = valorMoraDiaria;
	}

}
