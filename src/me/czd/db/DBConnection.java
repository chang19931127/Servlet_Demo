package me.czd.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/test";
	private String dbUser = "root";
	private String dbPass = "root";
	private Connection conn = null;

	public Connection getConnection() {
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public ResultSet doQuery(String sql, Object[] params) {
		ResultSet rs = null;
		conn = this.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int doUpdate(String sql,Object[] params) {
		int res = 0;
		conn = this.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
