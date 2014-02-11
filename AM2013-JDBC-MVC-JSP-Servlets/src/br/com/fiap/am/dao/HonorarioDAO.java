package br.com.fiap.am.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.bean.HonorarioBean;
import br.com.fiap.am.bean.TipoTarefaBean;
import br.com.fiap.am.jdbc.DBManager;

public class HonorarioDAO {
	
	
	
public void incluirHonorario(HonorarioBean honorario) {
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO t_am_unt_lanca_honorario " +
									   "(cd_lancamento, cd_tipo_tarefa, nr_processo, dt_honorario, qt_hora, ds_observacao) " +
									   "VALUES (SQ_AM_LANCA_HONORARIO.NEXTVAL, " +
									   "(SELECT cd_tipo_tarefa FROM t_am_unt_tipo_tarefa WHERE ds_tipo_tarefa LIKE ?), ?, ?, ?, ?) ");
			
			ps.setString(1, honorario.getTipoTarefa().getDescricao());
			ps.setInt(2, honorario.getProcesso().getNroProcesso());
			ps.setDate(3, new Date(honorario.getDataHonorario().getTime())); //De java.ultil.Date para java.sql.Date
			ps.setDouble(4, honorario.getQtdeHoras());
			ps.setString(5, honorario.getObs());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



public HonorarioBean consultarHonorario(int cdHonorario) {
	
	HonorarioBean honorario = new HonorarioBean();
	TipoTarefaBean tipoTarefa = new TipoTarefaBean();
	
	Connection conn = DBManager.getInstancia().getConnection();
	
	PreparedStatement ps = null;
	
	ResultSet rs = null;
	
	try {
		ps = conn.prepareStatement("SELECT tt.ds_tipo_tarefa, h.dt_honorario, h.qt_hora, h.ds_observacao " +
				   "FROM t_am_unt_lanca_honorario h JOIN t_am_unt_tipo_tarefa tt USING (cd_tipo_tarefa) " +
				   "WHERE h.cd_lancamento = ? ");
		
		ps.setInt(1, cdHonorario);
		
		rs = ps.executeQuery();
		rs.next();
		
		tipoTarefa.setDescricao(rs.getString(1));
		honorario.setTipoTarefa(tipoTarefa);
		honorario.setDataHonorario(rs.getDate(2));
		honorario.setQtdeHoras(rs.getDouble(3));
		honorario.setObs(rs.getString(4));
	
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return honorario;
}



	
public List<HonorarioBean> listarHonorarios(int nroProcesso) {
		
		List<HonorarioBean> honorarioList = new ArrayList<>();
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT h.cd_lancamento, " +
										"h.dt_honorario, " +
										"tt.ds_tipo_tarefa, " +
										"h.qt_hora " +
										"FROM t_am_unt_lanca_honorario h JOIN t_am_unt_tipo_tarefa tt USING (cd_tipo_tarefa) " +
										"WHERE nr_processo = ?");
			
			ps.setInt(1, nroProcesso); //Utiliza parâmetro do método dentro da cláusula WHERE
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				HonorarioBean honorario = new HonorarioBean();
				TipoTarefaBean tipoTarefa = new TipoTarefaBean();
				
				
				honorario.setCdHonorario(rs.getInt(1)); //Não será usado para listar Honorários, mas será usado para excluir Honorários *
				honorario.setDataHonorario(rs.getDate(2));
				tipoTarefa.setDescricao(rs.getString(3));
				honorario.setTipoTarefa(tipoTarefa);
				honorario.setQtdeHoras(rs.getDouble(4));
				
				honorarioList.add(honorario);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return honorarioList;
	}




	public void alterarHonorario(HonorarioBean honorario) {
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE t_am_unt_lanca_honorario " +
										"SET dt_honorario = ?, qt_hora = ?, ds_observacao = ? " +
										"WHERE cd_lancamento = ?");
			
			ps.setDate(1, new Date(honorario.getDataHonorario().getTime())); //De java.ultil.Date para java.sql.Date
			ps.setDouble(2, honorario.getQtdeHoras());
			ps.setString(3, honorario.getObs());
			ps.setInt(4, honorario.getCdHonorario());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	public void excluirHonorario(int cdHonorario) {
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		
		try {
			// O usuário poderá excluir um lançamento de honorários, através da seleção do ícone “EXCLUIR”, 
			// desde que o processo não esteja fechado ou bloqueado. 
			ps = conn.prepareStatement("DELETE FROM t_am_unt_lanca_honorario " +
									   "WHERE cd_lancamento = ? " +
									   "AND nr_processo IN (SELECT nr_processo FROM t_am_unt_processo WHERE nr_situacao = 2)"); //verificar nr_situacao
			
			ps.setInt(1, cdHonorario); //*cd_lancamento adquirido em listarDepesas() é utilizado aqui
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
