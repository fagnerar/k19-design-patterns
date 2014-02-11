package br.com.fiap.am.bo;

import java.util.List;

import br.com.fiap.am.bean.HonorarioBean;
import br.com.fiap.am.dao.HonorarioDAO;

public class HonorarioBO {
	
private HonorarioDAO honoDao = new HonorarioDAO();
	
	public void incluirHonorario(HonorarioBean honorario) {
		honoDao.incluirHonorario(honorario);
	}
	
	public HonorarioBean consultarHonorario(int cdHonorario) {
		return honoDao.consultarHonorario(cdHonorario);
	}
	
	public List<HonorarioBean> listarHonorarios(int nroProcesso) {
		return honoDao.listarHonorarios(nroProcesso);
	}
	
	public void alterarHonorario(HonorarioBean honorario) {
		honoDao.alterarHonorario(honorario);
	}
	
	public void excluirHonorario(int cdHonorario) {
		honoDao.excluirHonorario(cdHonorario);
	}

}
