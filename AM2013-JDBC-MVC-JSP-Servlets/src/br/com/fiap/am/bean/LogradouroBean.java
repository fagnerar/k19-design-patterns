package br.com.fiap.am.bean;

public class LogradouroBean {
	
	private int cep;
	private BairroBean codBairro;
	private TipoLogBean codTipoLog;
	private String descrição;
	
	public LogradouroBean() {}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public BairroBean getCodBairro() {
		return codBairro;
	}

	public void setCodBairro(BairroBean codBairro) {
		this.codBairro = codBairro;
	}

	public TipoLogBean getCodTipoLog() {
		return codTipoLog;
	}

	public void setCodTipoLog(TipoLogBean codTipoLog) {
		this.codTipoLog = codTipoLog;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
}
