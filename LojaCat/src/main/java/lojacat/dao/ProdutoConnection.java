package lojacat.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProdutoConnection {
	private static Connection con;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/brinquedo";
	private static String user = "root";
	private static String password = "";
	
	public static Connection conectar() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return(null);
		}
	}
}
