package br.com.fiap.am.bean;

public class FonePessoaBean {
	
	private PessoaBean codPessoa;
	private TelefoneBean codFone;
	private int ramal;
	
	public FonePessoaBean() {}

	public PessoaBean getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(PessoaBean codPessoa) {
		this.codPessoa = codPessoa;
	}

	public TelefoneBean getCodFone() {
		return codFone;
	}

	public void setCodFone(TelefoneBean codFone) {
		this.codFone = codFone;
	}

	public int getRamal() {
		return ramal;
	}

	public void setRamal(int ramal) {
		this.ramal = ramal;
	}

}
