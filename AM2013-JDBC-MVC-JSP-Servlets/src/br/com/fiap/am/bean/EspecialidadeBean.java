package br.com.fiap.am.bean;

public class EspecialidadeBean {
	
	private AdvogadoBean codAdvogado;
	private TipoCausaBean codCausa;

	public AdvogadoBean getCodAdvogado() {
		return codAdvogado;
	}

	public void setCodAdvogado(AdvogadoBean codAdvogado) {
		this.codAdvogado = codAdvogado;
	}

	public TipoCausaBean getCodCausa() {
		return codCausa;
	}

	public void setCodCausa(TipoCausaBean codCausa) {
		this.codCausa = codCausa;
	}

	public EspecialidadeBean() {}

}
