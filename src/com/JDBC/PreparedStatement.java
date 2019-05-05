package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PreparedStatement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO user VALUES(null,?,?)";
		try (
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
				Statement s = c.createStatement();
				)
		{
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
