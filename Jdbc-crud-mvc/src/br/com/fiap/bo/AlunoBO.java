package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.bean.AlunoBean;
import br.com.fiap.dao.AlunoDAO;

public class AlunoBO {
	
	private AlunoDAO alunoDAO = new AlunoDAO();
	
	public void incluirAluno(AlunoBean aluno) {
		alunoDAO.incluirAluno(aluno);
	}
	
	public void excluirAluno(int rm) {
		alunoDAO.excluirAluno(rm);
	}
	
	public void alterarAluno(int rm, String novaTurma) {
		alunoDAO.alterarAluno(rm, novaTurma);
	}
	
	public List<AlunoBean> listarAlunos() {
		return alunoDAO.listarAlunos();
	}

}
