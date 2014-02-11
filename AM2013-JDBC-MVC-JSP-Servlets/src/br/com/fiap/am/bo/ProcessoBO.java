package br.com.fiap.am.bo;

import java.util.List;

import br.com.fiap.am.bean.ProcessoBean;
import br.com.fiap.am.dao.ProcessoDAO;

public class ProcessoBO {
	
	private ProcessoDAO procDao = new ProcessoDAO();
	
	public List<ProcessoBean> listarProcessos() {
		return procDao.listarProcessos();
	}
	
	public ProcessoBean consultProcCli(int nroProcesso) {
		return procDao.consultProcCli(nroProcesso);
	}
	
	public ProcessoBean consultProcAdv(int nroProcesso) {
		return procDao.consultProcAdv(nroProcesso);
	}
	
	
}
