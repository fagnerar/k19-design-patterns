package br.com.fiap.am.bean;

public class TelefoneBean {
	
	private int codFone;
	private TipoFoneBean codTipoFone;
	private int DDD;
	private int intnumFone;
	
	public TelefoneBean() {}

	public int getCodFone() {
		return codFone;
	}

	public void setCodFone(int codFone) {
		this.codFone = codFone;
	}

	public TipoFoneBean getCodTipoFone() {
		return codTipoFone;
	}

	public void setCodTipoFone(TipoFoneBean codTipoFone) {
		this.codTipoFone = codTipoFone;
	}

	public int getDDD() {
		return DDD;
	}

	public void setDDD(int dDD) {
		DDD = dDD;
	}

	public int getIntnumFone() {
		return intnumFone;
	}

	public void setIntnumFone(int intnumFone) {
		this.intnumFone = intnumFone;
	}

}
