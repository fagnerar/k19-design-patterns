package br.com.fiap.am.bean;

import java.util.Date;

public class HonorarioBean {
	
	private int cdHonorario;
	private TipoTarefaBean tipoTarefa;
	private ProcessoBean processo;
	private Date dataHonorario;
	private double qtdeHoras;
	private String obs;
	
	public HonorarioBean() {}

	public int getCdHonorario() {
		return cdHonorario;
	}

	public void setCdHonorario(int cdHonorario) {
		this.cdHonorario = cdHonorario;
	}

	public TipoTarefaBean getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(TipoTarefaBean tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public ProcessoBean getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoBean processo) {
		this.processo = processo;
	}

	public Date getDataHonorario() {
		return dataHonorario;
	}

	public void setDataHonorario(Date dataHonorario) {
		this.dataHonorario = dataHonorario;
	}

	public double getQtdeHoras() {
		return qtdeHoras;
	}

	public void setQtdeHoras(double qtdeHoras) {
		this.qtdeHoras = qtdeHoras;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	

}
