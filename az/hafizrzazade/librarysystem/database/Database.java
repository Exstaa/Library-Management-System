package az.hafizrzazade.librarysystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private final static String URL = "jdbc:mysql://localhost/sent6group";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	private static Connection conn;

	public static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void dissconnect() {
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConn() {
		return conn;
	}
}
