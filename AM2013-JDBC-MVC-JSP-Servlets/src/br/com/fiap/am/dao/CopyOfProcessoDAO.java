package br.com.fiap.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.bean.ClienteBean;
import br.com.fiap.am.bean.ProcessoBean;
import br.com.fiap.am.jdbc.DBManager;

public class CopyOfProcessoDAO {
	
	public List<ProcessoBean> listarProcessos() {
		
		List<ProcessoBean> processoList = new ArrayList<>();
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

			try {
				ps = conn.prepareStatement("SELECT p.nr_processo, p.ds_processo, cl.ds_razao_social " +
											"FROM t_am_unt_processo p " +
											"JOIN t_am_unt_cliente cl " +
											"USING (cd_cliente) " +
											"WHERE p.nr_situacao = 2 "+ //Listar apenas os processos em aberto!! verificar nr_situacao
											"ORDER BY nr_processo");
				rs = ps.executeQuery();
				
				while (rs.next()) {
					ProcessoBean processo = new ProcessoBean();
					ClienteBean cliente = new ClienteBean();
					
					
					processo.setNroProcesso(rs.getInt(1));
					processo.setDescricao(rs.getString(2));
					cliente.setRazaoSocial(rs.getString(3));
					
					processo.setCliente(cliente);
					
					processoList.add(processo);
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
			
		return processoList;
	}
}
