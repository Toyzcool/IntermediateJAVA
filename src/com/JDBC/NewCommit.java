package com.JDBC;
/*
 * 事务
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewCommit {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
				Statement s = c.createStatement();
				)
		{
			/*
			 * 使用事务
			 */
			//自动提交关闭
			c.setAutoCommit(false);
			
			//查询血量语句
			String sqlResearch = "SELECT * from hero where id = 2 ";
			
			//增加血量操作
			String sqlAdd = "UPDATE hero SET hp= hp + 1 where id = 2 ";
			s.execute(sqlAdd);
			System.out.println("加血成功");
			//获取血量
			ResultSet rs = s.executeQuery(sqlResearch);
			rs.next();
			float hp1 = rs.getFloat("hp");
			System.out.println("加血后血量为："+hp1);

			//减少血量操作
			String sqlReduce = "UPDATA hero SET hp= hp - 1 where id = 2 ";
			s.execute(sqlReduce);
			System.out.println("减血成功");
			//获取血量
			ResultSet rs2 = s.executeQuery(sqlResearch);
			rs2.next();
			float hp2 = rs2.getFloat("hp");
			System.out.println("减血后血量为："+hp2);
			
			//手动提交
			c.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
