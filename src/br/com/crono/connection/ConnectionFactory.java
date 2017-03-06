package br.com.crono.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static ConnectionFactory conn = null;
	
	public static ConnectionFactory controlarInstancia(){
		if(conn == null){
			conn = new ConnectionFactory();
		}
		return conn;
	}
	
	public Connection getConnection() throws SQLException{
		
		String url = "jdbc:oracle:thin:/:@oracle.fiap.com.br:1521:ORCL";
		String user = "OPS$RM76747";
		String password = "280895";
		
		return DriverManager.getConnection(url,user,password);
	}
	

}
