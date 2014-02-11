package br.com.fiap.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.bean.AdvogadoBean;
import br.com.fiap.am.bean.ClienteBean;
import br.com.fiap.am.bean.HoraAdvogadoBean;
import br.com.fiap.am.bean.ProcessoBean;
import br.com.fiap.am.jdbc.DBManager;

public class ProcessoDAO {
	
	
	
public ProcessoBean consultProcCli(int nroProcesso) {
		
		ProcessoBean processo = new ProcessoBean();
		ClienteBean cliente = new ClienteBean();
		
		Connection conn = DBManager.getInstancia().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT pr.nr_processo, p.nm_pessoa " +
									   "FROM t_am_unt_processo pr JOIN t_am_unt_cliente USING (cd_cliente) " +
									   "INNER JOIN t_am_unt_pessoa p ON (cd_cliente = cd_pessoa) " +
									   "WHERE pr.nr_processo = ? ");
		
			ps.setInt(1, nroProcesso);
			
			rs = ps.executeQuery();
			rs.next();
			
			processo.setNroProcesso(rs.getInt(1));
			cliente.setNome(rs.getString(2));
			processo.setCliente(cliente);
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return processo;
	}
	
	
	
	public ProcessoBean consultProcAdv(int nroProcesso) {
		
		ProcessoBean processo = new ProcessoBean();
		AdvogadoBean advogado = new AdvogadoBean();
		HoraAdvogadoBean horaAdv = new HoraAdvogadoBean();
		
		Connection conn = DBManager.getInstancia().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT p.nm_pessoa, ha.vl_hora  " +
					   "FROM t_am_unt_processo pr JOIN t_am_unt_especialidade e USING (cd_advogado) " +
					   "JOIN t_am_unt_advogado ad USING (cd_advogado) " +
					   "JOIN t_am_unt_hora_advogado ha USING (cd_advogado) " +
					   "INNER JOIN t_am_unt_pessoa p ON (cd_advogado = cd_pessoa) " +
					   "WHERE pr.nr_processo = ? AND ROWNUM = 1");
		
			ps.setInt(1, nroProcesso);
			
			rs = ps.executeQuery();
			rs.next();
			
			advogado.setNome(rs.getString(1));
			horaAdv.setValorHora(rs.getDouble(2));
			advogado.setHoraAdvogado(horaAdv);
			processo.setAdvogado(advogado);
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return processo;
	}
	


	
	
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
