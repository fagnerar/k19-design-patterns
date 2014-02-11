package br.com.fiap.am.bean;

import java.util.List;

public class AdvogadoBean extends PessoaBean {
	
	private int nroOAB;
	private int cpf;
	private String rg;
	private String email;
	private String senha;
	private HoraAdvogadoBean horaAdvogado;
	private List<TipoCausaBean> tipoCausaList;
	
	public AdvogadoBean() {}

	public int getNroOAB() {
		return nroOAB;
	}

	public void setNroOAB(int nroOAB) {
		this.nroOAB = nroOAB;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<TipoCausaBean> getTipoCausaList() {
		return tipoCausaList;
	}

	public HoraAdvogadoBean getHoraAdvogado() {
		return horaAdvogado;
	}

	public void setHoraAdvogado(HoraAdvogadoBean horaAdvogado) {
		this.horaAdvogado = horaAdvogado;
	}

	public void setTipoCausaList(List<TipoCausaBean> tipoCausaList) {
		this.tipoCausaList = tipoCausaList;
	}
	
	

}
