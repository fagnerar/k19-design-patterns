package br.com.fiap.am.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
private static DBManager instancia;
	
	public static DBManager getInstancia() {
		if (instancia == null)
			instancia = new DBManager();
		return instancia;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@SEU-BANCO-DE-DADOS:1521:ORCL", "SEU-LOGIN",
					"SUA-SENHA");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
