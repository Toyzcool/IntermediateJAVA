package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * ORM(object relationship database mapping)
 * 将数据库中的表格变成java中的对象
 * 关联：Hero.java
 */
public class NewORM_main {

	public static void main(String[] args) {
		Hero hero = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (		
				Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
				Statement s = c.createStatement();
				)
		{
			//查询数据库中数据
			String sql = "SELECT * FROM hero";
			ResultSet rs = s.executeQuery(sql);
			//将数据赋值给Java对象
			while(rs.next()) {
				hero = new Hero();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float hp = rs.getFloat("hp");
				int damage = rs.getInt("damage");
				hero.id = id;
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				System.out.println(hero.id+hero.name+"hp:"+hero.hp+"damage:"+hero.damage);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
