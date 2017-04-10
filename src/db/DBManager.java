package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import db.DBManager;

public class DBManager {
	static private DBManager instance;
	Connection con;
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:XE";
	private String user="bread";
	private String password="bread";

	
	private DBManager(){
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static DBManager getInstance() {
		if(instance == null){
			instance = new DBManager();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
	public void disConnect(Connection con){
		if(con !=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
