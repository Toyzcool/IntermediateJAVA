package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login_main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库加载成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
			Statement s = c.createStatement();
			){
			//获取输入的账号
			System.out.print("请输入账号：");
			String name = console.next();
			//获取输入的密码
			System.out.print("请输入密码：");
			String password = console.next();
			//使用sql语句查询
			String sql = "select * from user where name = '"+name+"'and password = '"+password+"'";
			//执行语句，并将返回值赋值给ResultSet
			ResultSet rs = s.executeQuery(sql);
			//判断返回值
			if(rs.next()) {
				System.out.println("账号密码正确");
			}else {
				System.out.println("账号密码错误");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
