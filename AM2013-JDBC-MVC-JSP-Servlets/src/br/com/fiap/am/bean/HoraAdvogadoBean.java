package br.com.fiap.am.bean;

import java.util.Date;

public class HoraAdvogadoBean {
	
	private AdvogadoBean codAdvogado;
	private int codHistHora;
	private Date dataVigencia;
	private double valorHora;
	
	public HoraAdvogadoBean() {}

	public AdvogadoBean getCodAdvogado() {
		return codAdvogado;
	}

	public void setCodAdvogado(AdvogadoBean codAdvogado) {
		this.codAdvogado = codAdvogado;
	}

	public int getCodHistHora() {
		return codHistHora;
	}

	public void setCodHistHora(int codHistHora) {
		this.codHistHora = codHistHora;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

}
