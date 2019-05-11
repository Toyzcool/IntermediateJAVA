package com.Practice.UserManageSystem;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {
	String[] columnItem = new String[] {"ID","Name","Password"};
	
	//获取用户列表
	public List<User> users = new UserDAO().list();
	
	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public int getColumnCount() {
		return columnItem.length;
	}
	
	//获取每一列名称	
	public String getColumnName(int columnIndex) {
	    return columnItem[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = users.get(rowIndex);
		if(0 == columnIndex)
			return user.id;
		if(1 == columnIndex)
			return user.name;
		if(2 == columnIndex)
			return user.password;
		return null;
	}

}
