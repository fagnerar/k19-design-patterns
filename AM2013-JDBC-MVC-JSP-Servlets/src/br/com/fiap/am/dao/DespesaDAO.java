package br.com.fiap.am.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.bean.DespesaBean;
import br.com.fiap.am.bean.TipoDespesaBean;
import br.com.fiap.am.jdbc.DBManager;

public class DespesaDAO {
	
	
	
	
	public void incluirDespesa(DespesaBean despesa) {
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO t_am_unt_lanca_despesa " +
									   "(cd_lancamento, cd_tipo_despesa, nr_processo, dt_despesa, vl_despesa, ds_observacao) " +
									   "VALUES (SQ_AM_LANCA_DESPESA.NEXTVAL, " +
									   "(SELECT cd_tipo_despesa FROM t_am_unt_tipo_despesa WHERE ds_tipo_despesa LIKE ?), ?, ?, ?, ?)");
			
			ps.setString(1, despesa.getTipoDespesa().getDescricao());
			ps.setInt(2, despesa.getProcesso().getNroProcesso());
			ps.setDate(3, new Date(despesa.getDataDespesa().getTime())); //De java.ultil.Date para java.sql.Date
			ps.setDouble(4, despesa.getValorDespesa());
			ps.setString(5, despesa.getObs());
			
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
	
	
	
	
	public DespesaBean consultarDespesa(int cdDespesa) {
		
		DespesaBean despesa = new DespesaBean();
		TipoDespesaBean tipoDespesa = new TipoDespesaBean();
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT td.ds_tipo_despesa, d.dt_despesa, d.vl_despesa, d.ds_observacao " +
									   "FROM t_am_unt_lanca_despesa d JOIN t_am_unt_tipo_despesa td " +
									   "USING (cd_tipo_despesa) " +
									   "WHERE d.cd_lancamento = ?");
			
			ps.setInt(1, cdDespesa);
			
			rs = ps.executeQuery();
			rs.next();
			
			despesa.setCdDespesa(cdDespesa);
			
			tipoDespesa.setDescricao(rs.getString(1));
			despesa.setTipoDespesa(tipoDespesa);
			
			despesa.setDataDespesa(rs.getDate(2));
			
			despesa.setValorDespesa(rs.getDouble(3));
			
			despesa.setObs(rs.getString(4));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return despesa;
	}
	
	
	
	
	public List<DespesaBean> listarDespesas(int nroProcesso) {
		
		List<DespesaBean> despesaList = new ArrayList<>();
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT d.cd_lancamento, " +
										"d.dt_despesa, " +
										"td.ds_tipo_despesa, " +
										"d.vl_despesa " +
										"FROM t_am_unt_lanca_despesa d JOIN t_am_unt_tipo_despesa td USING (cd_tipo_despesa) " +
										"WHERE d.nr_processo = ?");
			
			ps.setInt(1, nroProcesso); //Utiliza parâmetro do método dentro da cláusula WHERE
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				DespesaBean despesa = new DespesaBean();
				TipoDespesaBean tipoDespesa = new TipoDespesaBean();
				
				
				despesa.setCdDespesa(rs.getInt(1)); //Não será usado para listar Despesas, mas será usado para excluir Despesa *
				despesa.setDataDespesa(rs.getDate(2));
				tipoDespesa.setDescricao(rs.getString(3));
				despesa.setValorDespesa(rs.getDouble(4));
				
				despesa.setTipoDespesa(tipoDespesa);
				
				despesaList.add(despesa);
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
		
		return despesaList;
	}
	
	
	
	
	public void alterarDespesa(DespesaBean despesa) {
		
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE t_am_unt_lanca_despesa " +
										"SET dt_despesa = ?, vl_despesa = ?, ds_observacao = ? " +
										"WHERE cd_lancamento = ?");
			
			ps.setDate(1, new Date(despesa.getDataDespesa().getTime())); //De java.ultil.Date para java.sql.Date
			ps.setDouble(2, despesa.getValorDespesa());
			ps.setString(3, despesa.getObs());
			ps.setInt(4, despesa.getCdDespesa());
			
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
	
	
	
	
	public void excluirDespesa(int cdDespesa) {
		Connection conn = DBManager.getInstancia().getConnection();
		
		PreparedStatement ps = null;
		
		try {
			// O usuário poderá excluir um lançamento de despesas, através da seleção do ícone “EXCLUIR”, 
			// desde que o processo não esteja fechado ou bloqueado. 
			ps = conn.prepareStatement("DELETE FROM t_am_unt_lanca_despesa " +
									   "WHERE cd_lancamento = ? " +
									   "AND nr_processo IN (SELECT nr_processo FROM t_am_unt_processo WHERE nr_situacao = 2)"); //verificar nr_situacao
			
			ps.setInt(1, cdDespesa); //*cd_lancamento adquirido em listarDepesas() é utilizado aqui
			
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
