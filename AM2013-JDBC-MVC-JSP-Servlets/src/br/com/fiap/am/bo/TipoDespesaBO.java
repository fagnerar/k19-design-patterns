package br.com.fiap.am.bo;

import java.util.List;

import br.com.fiap.am.bean.TipoDespesaBean;
import br.com.fiap.am.dao.TipoDespesaDAO;

public class TipoDespesaBO {
	
	private TipoDespesaDAO tipoDespDAO = new TipoDespesaDAO();
	
	public List<TipoDespesaBean> listarTipoDespesas() {
		return tipoDespDAO.listarTipoDespesa();
	}

}
