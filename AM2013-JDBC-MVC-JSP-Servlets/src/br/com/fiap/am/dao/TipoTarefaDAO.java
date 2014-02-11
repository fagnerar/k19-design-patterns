package br.com.fiap.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.bean.TipoTarefaBean;
import br.com.fiap.am.jdbc.DBManager;

public class TipoTarefaDAO {
	
	public List<TipoTarefaBean> listarTipoTarefa() {
		List<TipoTarefaBean> tipoTarefaList = new ArrayList<>();
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT cd_tipo_tarefa, ds_tipo_tarefa " +
									   "FROM t_am_unt_tipo_tarefa " +
									   "ORDER BY ds_tipo_tarefa");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				TipoTarefaBean tipoTarefBean = new TipoTarefaBean();
				
				int cdTipoTarefa = rs.getInt("cd_tipo_tarefa");
				String descricao = rs.getString("ds_tipo_tarefa");
				
				tipoTarefBean.setCdTipoTarefa(cdTipoTarefa);
				tipoTarefBean.setDescricao(descricao);
				
				tipoTarefaList.add(tipoTarefBean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tipoTarefaList;
	}

}
