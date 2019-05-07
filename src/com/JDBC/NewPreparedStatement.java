package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NewPreparedStatement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		String sql = "INSERT INTO user VALUES(null,?,?)";
		try (
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
				//预编译
//				PreparedStatement ps =  c.prepareStatement(sql);
				//普通编译
				Statement s = c.createStatement();
				)
		{
//            //使用预编译
//            ps.setString(1, "stark");
//            ps.setString(2, "admin");
//			ps.execute();
//			System.out.println("添加完成");
			
			//使用普通编译进行SQL注入攻击
			//获取用户输入
			String inputName = "'盖伦' OR 1=1";
			//新建查询SQL语句
			String sqlAttrack = "SELECT * FROM user where name = "+inputName;
			//执行查询语句
			ResultSet rs = s.executeQuery(sqlAttrack);
			//输出账号是否存在
			while(rs.next()) {
				String userName = rs.getString("password");
				System.out.println(userName);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
