package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.AlunoBean;
import br.com.fiap.jdbc.DBManager;

public class AlunoDAO {
	
	public void incluirAluno(AlunoBean aluno) {
		
		PreparedStatement ps = null;
		Connection conn = DBManager.getInstancia().getConnection();
		
		try {
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement("INSERT INTO W_TB_ALUNO (id_aluno, rm, nome, turma, ano, ativo) values (w_sq_aluno.nextval, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, aluno.getRm());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getTurma());
			ps.setInt(4, aluno.getAno());
			if (aluno.isAtivo())
				ps.setInt(5, 1);
			else
				ps.setInt(5, 0);
			
			ps.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void excluirAluno(int rm) {
		
		PreparedStatement ps = null;
		Connection conn = DBManager.getInstancia().getConnection();
		
		try {
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement("DELETE FROM w_tb_aluno WHERE rm = ?");
			ps.setInt(1, rm);
			ps.executeUpdate();
			
			conn.commit();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void alterarAluno(int rm, String novaTurma) {
		PreparedStatement ps = null;
		Connection conn = DBManager.getInstancia().getConnection();
		
		try {
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement("UPDATE w_tb_aluno SET turma = ? WHERE rm = ?");
			
			ps.setString(1, novaTurma);
			ps.setInt(2, rm);
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public List<AlunoBean> listarAlunos() {
		
		List<AlunoBean> alunoList = new ArrayList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		try {
			
			ps = conn.prepareStatement("SELECT turma, ano, rm, nome FROM w_tb_aluno");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				AlunoBean alunoBean = new AlunoBean();
				alunoBean.setTurma(rs.getString("turma"));
				alunoBean.setAno(rs.getInt("ano"));
				alunoBean.setRm(rs.getInt("rm"));
				alunoBean.setNome(rs.getString("nome"));
				
				alunoList.add(alunoBean);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return alunoList;
	}
	
	
}
