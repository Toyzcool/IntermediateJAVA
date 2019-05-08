package com.JDBC;

import java.util.List;

/*
 * DAO(data access object)
 * 数据库相关的操作都封装在这个接口里面，其他地方看不到JDBC的代码
 * 关联：HeroDAO.java
 */
public interface DAO {
	//增加
	public void add(Hero hero);
	//删除
	public void delete(int id);
	//修改
	public void update(Hero hero);
	//获取
	public Hero get(int id);
	//查询
	public List<Hero> list(int start,int count);
}