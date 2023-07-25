package in.thamimsubansait.doboo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {

		Connection connection = null;
		String url = null;
		String userName = null;
		String passWord = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection(
			  "jdbc:mysql://aws.connect.psdb.cloud/doboo?sslMode=VERIFY_IDENTITY",
			  "9ig6n24m31ljo6pzxm3o",
			  "pscale_pw_5PG6ompn8ByhEofZlrmc4FoE4DtlD73O639C0aO0qZs");


		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return connection;
	}

	public static void close(Connection connection, PreparedStatement ps) {
		try {
			if(ps != null) {
				ps.close();
			}
			if(connection != null) {
				connection.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection connection, PreparedStatement ps,ResultSet res) {
		try {
			if(res!=null) {
				res.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(connection != null) {
				connection.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

