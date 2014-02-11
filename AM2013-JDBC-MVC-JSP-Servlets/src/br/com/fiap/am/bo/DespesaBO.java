package br.com.fiap.am.bo;

import java.util.List;

import br.com.fiap.am.bean.DespesaBean;
import br.com.fiap.am.dao.DespesaDAO;

public class DespesaBO {
	
	private DespesaDAO despDao = new DespesaDAO();
	
	public void incluirDespesa(DespesaBean despesa) {
		despDao.incluirDespesa(despesa);
	}
	
	public DespesaBean consultarDespesa(int cdDespesa) {
		return despDao.consultarDespesa(cdDespesa);
	}
	
	public List<DespesaBean> listarDespesas(int nroProcesso) {
		return despDao.listarDespesas(nroProcesso);
	}
	
	public void alterarDepesa(DespesaBean despesa) {
		despDao.alterarDespesa(despesa);
	}
	
	public void excluirDespesa(int cdDespesa) {
		despDao.excluirDespesa(cdDespesa);
	}

}
