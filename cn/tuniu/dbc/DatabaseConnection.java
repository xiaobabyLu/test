package cn.tuniu.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static final String DBDRIVER="mysql.jdbc.driver.MysqlDriver";
	public static final String DBURL="";
	public static final String USER="";
	public static final String PASSWORD="";
	private Connection conn=null;


	public DatabaseConnection(){
		try {
			Class.forName(DBDRIVER);
			this.conn=DriverManager.getConnection(DBURL,USER,PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close(){
		if(this.conn!=null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
