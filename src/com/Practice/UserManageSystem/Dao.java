package com.Practice.UserManageSystem;

import java.util.List;

public interface Dao {
	//新增方法
	public void add(User user) ;
	//删除方法
	public void delete(int id);
	//修改方法
	public void update(User user);
	//获取方法
	public User get(int id);
	//查询方法
	public List<User> list();
	//分页查询方法
	public List<User> list(int start,int count);
}
