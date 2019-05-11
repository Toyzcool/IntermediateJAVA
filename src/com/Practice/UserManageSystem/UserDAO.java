package com.Practice.UserManageSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Practice.UserManageSystem.*;


/*
 * 实现DAO中的方法
 */
public class UserDAO implements Dao{
	/*
	 * 将驱动放在构造方法中
	 */
	public UserDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("初始化成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取数据连接
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlTest?characterEcoding=utf8","root","admin123");
	}
	
	/*
	 * 增加方法
	 */
	public void add(User user) {
		//编写PreparedStatement语句
		String sql = "insert into user values(null,?,?)";
		//创建连接并传输语句
		try (
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				)
		{
			c.setAutoCommit(false);
			//传参数到数据库
			ps.setString(1, user.name);
			ps.setInt(2, user.password);
			ps.execute();
			//获取ID并赋值给user
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				int id = rs.getInt(1);
				user.id = id;
			}
			c.commit();//手动提交
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 删除方法
	 */
	public void delete(int id) {
		String sql = "delete from user where id = ?";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			ps.setInt(1,id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 更新方法
	 */
	public void update(User user) {
		String sql = "update user set name = ? , password = ? where id = ?";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			c.setAutoCommit(false);
			ps.setString(1,user.name);
			ps.setInt(2, user.password);
			ps.setInt(3, user.id);
			ps.execute();
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取方法
	 */
	public User get(int id) {
		String sql = "Select * from user where id = ?";
		User user = null;
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			c.setAutoCommit(false);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				user = new User();//新建用户用于存储查询到的对象
				String name = rs.getString("name");
				int password = rs.getInt("password");
				user.name = name;
				user.password = password;
				c.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/*
	 * 返回整个列表
	 */
	public List<User> list(){
		return list(0,Short.MAX_VALUE);
	}

	/*
	 * 分页返回数据
	 */
	public List<User> list(int start, int count) {
		//新建用户组
		List<User> users = new ArrayList<User>();
		String sql = "select * from user order by id desc limit ? , ?";
		try(
				Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				)
		{
			c.setAutoCommit(false);
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//将获取到的数据库中的user数据赋值给user对象
				User user = new User();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int password = rs.getInt("password");
				user.id = id;
				user.name = name;
				user.password = password;
				//将赋值成功的数据加入用户组
				users.add(user);
			}
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回用户组
		return users;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
