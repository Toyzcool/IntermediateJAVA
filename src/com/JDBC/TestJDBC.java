package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJDBC {

	public static void main(String[] args) {
		/*
		 * 初始化驱动，连接数据库，并写入数据，最后使用try-with-resource关闭
		 */
		try {
			/*
			 * 初始化驱动
			 */
			//驱动类com.mysql.jdbc.Driver，就在mysql-connector-java-8.0.16.jar包中，导入包
			Class.forName("com.mysql.cj.jdbc.Driver");
			//导入成功输出提示
			System.out.println("数据库加载成功");
		try(
				//连接数据库
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
				//新建写sql语句的对象
				Statement s = c.createStatement();
			)
		{
			//新建sql语句
			String sql = "insert into hero values(null,'诺克萨斯',900,120)";
			s.execute(sql);
			System.out.println("数据写入成功");
			
			/*
			 * 查询
			 */
			String sqlSearch = "select * from hero";
			//执行sql语句，返回查询结果
			ResultSet rs = s.executeQuery(sqlSearch);
			System.out.println("ID\tName\tHp\tDamage\t");
			while(rs.next()) {
				//获取ID
				int id = rs.getInt("id");
				//获取name
				String name = rs.getString(2);
				//获取hp和damage
				float hp = rs.getFloat(3);
				int damage = rs.getInt("damage");
				System.out.printf("%d\t%s\t%.0f\t%d%n",id,name,hp,damage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
