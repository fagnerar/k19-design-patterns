package br.com.fiap.am.bo;

import java.util.List;

import br.com.fiap.am.bean.TipoTarefaBean;
import br.com.fiap.am.dao.TipoTarefaDAO;

public class TipoTarefaBO {
	
	private TipoTarefaDAO tipoTarefDAO = new TipoTarefaDAO();
	
	public List<TipoTarefaBean> listarTipoTarefa() {
		
		return tipoTarefDAO.listarTipoTarefa();
		
	}

}
