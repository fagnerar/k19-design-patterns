package br.com.fiap.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.bean.TipoDespesaBean;
import br.com.fiap.am.jdbc.DBManager;

public class TipoDespesaDAO {
	
	public List<TipoDespesaBean> listarTipoDespesa() {
		List<TipoDespesaBean> tipoDespesaList = new ArrayList<>();
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT cd_tipo_despesa, ds_tipo_despesa " +
									   "FROM t_am_unt_tipo_despesa " +
									   "ORDER BY ds_tipo_despesa");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				TipoDespesaBean tipoDespBean = new TipoDespesaBean();
				
				int cdTipoDespesa = rs.getInt("cd_tipo_despesa");
				String descricao = rs.getString("ds_tipo_despesa");
				
				tipoDespBean.setCdTipoDespesa(cdTipoDespesa);
				tipoDespBean.setDescricao(descricao);
				
				tipoDespesaList.add(tipoDespBean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tipoDespesaList;
	}

}
