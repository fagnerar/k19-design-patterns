package br.com.fiap.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
	
	private static DBManager instancia;
	
	private DBManager() {}
	
	public static DBManager getInstancia() {
		if (instancia == null) 
			instancia = new DBManager();
		return instancia;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Utilizando Oracle Database XE Edition localmente
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "seu-login", "sua-senha");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
