package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/*
 * DAO接口的设计类，实现接口DAO
 * 关联：DAO.java
 */
import java.util.List;

public class HeroDAO implements DAO {
	//将驱动的初始化放在当前类的构造方法中
	public HeroDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动初始化成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//提供getConnection方法返回连接
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
	}
	
	//获取数据总数方法
	public int getTotal() {
		int total = 0;
		try (
				Connection c = getConnection();
				Statement s = c.createStatement();
				)
		{
			String sql = "select count(*) from hero";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				total = rs.getInt(1);
			}
			System.out.println("Total:"+total);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	//添加
	public void add(Hero hero) {
		String sql = "insert into hero values(null,?,?,?)";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				) 
		{
			//创建事务
			c.setAutoCommit(false);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.execute();
			//获取数据库分配的ID
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				hero.id = id;
			}
			//手动提交
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//删除
	//根据ID删除
	public void delete(int id) {
		String sql = "delete from hero where id = ?";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//更新

	//更新
	public void update(Hero hero) {
		String sql = "update hero set name = ?, hp = ?, damage = ? where id = ?";
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			//创建事务
			c.setAutoCommit(false);
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.setInt(4, hero.id);
			ps.execute();
			//手动提交事务
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取
	
	//获取相应ID的hero对象
	public Hero get(int id) {
		String sql = "select * from hero where id = ?";
		Hero hero = null;
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			ps.setInt(1, id);
			//获取
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				hero = new Hero();
				String name = rs.getString("name");
				float hp = rs.getFloat("hp");
				int damage = rs.getInt("damage");
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				hero.id = id;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hero;
	}
	
	//分页输出

	//分页输出列表中hero对象
	public List<Hero> list(int start,int count) {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Hero> heros = new ArrayList();
		String sql = "select * from hero order by id desc limit ? , ?";
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			//传值到数据库
			ps.setInt(1, start);
			ps.setInt(2, count);
			//获取数据库返回值
			ResultSet rs = ps.executeQuery();
			//赋值给Hero对象
			while(rs.next()) {
				Hero hero = new Hero();
				int id = rs.getInt("id");
				String name = rs.getString(2);
				float hp = rs.getFloat(3);
				int damage = rs.getInt(4);
				hero.id = id;
				hero.name = name;
				hero.hp = hp;
				hero.damage = damage;
				heros.add(hero);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return heros;
	}

	public static void main(String[] args) {
		HeroDAO hd = new HeroDAO();
		hd.getTotal();
		//测试添加功能
		Hero hero1 = new Hero("VN",500,300);
		hd.add(hero1);
		System.out.println("添加成功");
		//测试删除功能
		hd.delete(2);
		System.out.println("删除成功");
		//测试更新功能
		Hero hero2 = new Hero(32,"NewVN",5000,5000);
		hd.update(hero2);
		System.out.println("更新成功");
		//获取一条数据
		Hero hero3 = hd.get(32);
		System.out.printf("英雄ID为%d的名字为%s,血量为%.1f,攻击为%d\n",hero3.id,hero3.name,hero3.hp,hero3.damage);
		//输出从1到10的英雄
		System.out.println("-----分页输出-----");
		List<Hero> heros = hd.list(1, 40);
		for (Hero hero : heros) {
			System.out.printf("英雄ID为%d的名字为%s,血量为%.1f,攻击为%d\n",hero.id,hero.name,hero.hp,hero.damage);
		}
	}



}
